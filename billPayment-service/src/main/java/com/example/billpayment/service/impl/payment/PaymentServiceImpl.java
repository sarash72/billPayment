package com.example.billpayment.service.impl.payment;

import com.example.billpayment.api.dto.enumeration.Status;
import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentResponseApi;
import com.example.billpayment.service.api.BillAppService;
import com.example.billpayment.service.api.PaymentService;
import com.example.billpayment.service.api.persistence.PaymentServiceApi;
import com.example.billpayment.service.dto.bill.BillServiceDto;
import com.example.billpayment.service.dto.payment.PaymentDto;
import com.example.billpayment.service.dto.payment.PaymentRequestDto;
import com.example.billpayment.service.dto.payment.PaymentResponseDto;
import com.example.billpayment.service.impl.bill.mapper.BillServiceMapper;
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
    private final BillServiceMapper billServiceMapper;


    public PaymentServiceImpl(PaymentServiceApi paymentServiceApi, PaymentMapper paymentMapper, BillAppService billAppService, BillServiceMapper billServiceMapper) {
        this.paymentServiceApi = paymentServiceApi;
        this.paymentMapper = paymentMapper;
        this.billAppService = billAppService;
        this.billServiceMapper = billServiceMapper;
    }

    @Override
    @Transactional
    public PaymentResponseApi payBill(PaymentRequestApi paymentRequestApi) {
        PaymentRequestDto paymentRequestDto = paymentMapper.toPaymentRequestDto(paymentRequestApi);
        /** پیدا کردن قبض
         *
         */
        BillServiceDto myBill = billServiceMapper.toBillRequestDto(billAppService.getBillById(paymentRequestDto.getBillId()));
        if (myBill.getBillTd().isEmpty()) {
            throw new RuntimeException("قبض پیدا نشد.");
        }
        if (myBill.getStatus() == Status.PAID) {
            throw new RuntimeException("قبض قبلاً پرداخت شده است.");
        }

        String refId = UUID.randomUUID().toString();

        PaymentDto payment = PaymentDto.builder()
                .refId(refId)
                .paymentDate(LocalDate.now())
                .bill(myBill)
                .build();
        PaymentStrategy strategy = PaymentFactory.getPaymentStrategy(paymentRequestDto.getPaymentType());
        paymentServiceApi.savePayment(payment);


        /**
         * pay with payment type
         */
        strategy.pay(paymentRequestDto.getBillId());
        return paymentMapper.toPaymentResponseApi(paymentServiceApi.payBill(paymentRequestDto));
    }

}
