package com.example.billpayment.service.impl.payment;

import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentResponseApi;
import com.example.billpayment.service.api.BillAppService;
import com.example.billpayment.service.api.PaymentService;
import com.example.billpayment.service.api.persistence.PaymentServiceApi;
import com.example.billpayment.service.dto.bill.BillServiceDto;
import com.example.billpayment.service.dto.payment.PaymentRequestDto;
import com.example.billpayment.service.dto.payment.PaymentResponseDto;
import com.example.billpayment.service.impl.payment.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentServiceApi paymentServiceApi;
    private final PaymentMapper paymentMapper;
    private final BillAppService billAppService;

    public PaymentServiceImpl(PaymentServiceApi paymentServiceApi, PaymentMapper paymentMapper, BillAppService billAppService) {
        this.paymentServiceApi = paymentServiceApi;
        this.paymentMapper = paymentMapper;
        this.billAppService = billAppService;
    }

    @Override
    public PaymentResponseApi payBill(PaymentRequestApi paymentRequestApi) {
        PaymentRequestDto paymentRequestDto = paymentMapper.toPaymentRequestDto(paymentRequestApi);
        /** پیدا کردن قبض
         *
         */
        Optional<BillServiceDto> optionalBill = billAppService..findById(paymentRequestDto.getBillId());
        if (optionalBill.isEmpty()) {
            throw new RuntimeException("قبض پیدا نشد.");
        }

        Bill bill = optionalBill.get();

        if (bill.getStatus() == Status.PAID) {
            throw new RuntimeException("قبض قبلاً پرداخت شده است.");
        }

        PaymentStrategy strategy = PaymentFactory.getPaymentStrategy(paymentRequestDto.getPaymentType());

        /**
         * pay with payment type
         */
        strategy.pay(paymentRequestDto.getBillId());
        return paymentMapper.toPaymentResponseApi(paymentServiceApi.payBill(paymentRequestDto));
    }

    @Transactional
    public PaymentResponseDto payBill(PaymentRequestDto paymentRequestDto) {


        String refId = UUID.randomUUID().toString();

        Payment payment = Payment.builder()
                .refId(refId)
                .paymentDate(LocalDate.now())
                .bill(bill)
                .build();

        paymentRepository.save(payment);

        bill.setStatus(Status.PAID);
        bill.setPayment(payment);
        billRepository.save(bill);

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setRefId(refId);
        return paymentResponseDto;
    }

}
