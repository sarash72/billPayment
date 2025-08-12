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
import com.example.billpayment.service.impl.bill.BillServiceImpl;
import com.example.billpayment.service.impl.bill.mapper.BillServiceMapper;
import com.example.billpayment.service.impl.payment.mapper.PaymentServiceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentServiceApi paymentServiceApi;
    private final PaymentServiceMapper paymentMapper;
    private final BillAppService billAppService;
    private final BillServiceMapper billServiceMapper;


    public PaymentServiceImpl(PaymentServiceApi paymentServiceApi, PaymentServiceMapper paymentMapper, BillAppService billAppService, BillServiceMapper billServiceMapper, BillServiceImpl billServiceImpl) {
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
        billAppService.getBillByBillId(paymentRequestDto.getBillId());
        BillServiceDto myBill = billServiceMapper.toBillRequestDto(billAppService.getBillByBillId(paymentRequestDto.getBillId()));
        if (myBill==null || myBill.getBillId().isEmpty()) {
            throw new RuntimeException("قبض پیدا نشد.");
        }
        if (myBill.getStatus() == Status.PAID) {
            throw new RuntimeException("قبض قبلاً پرداخت شده است.");
        }

        String refId = UUID.randomUUID().toString();

        PaymentDto payment = PaymentDto.builder()
                .refId(refId)
                .paymentDate(LocalDate.now())
                .billId(myBill.getBillId())
                .build();

        /**
         * pay with payment type
         */
        PaymentStrategy strategy = PaymentFactory.getPaymentStrategy(paymentRequestDto.getPaymentType());
        strategy.pay(paymentRequestDto.getBillId());

        myBill.setStatus(Status.PAID);
        System.out.println("22222222222...."+myBill.getUserId());
        System.out.println("..............:"+myBill.toString());
        System.out.println(".111111111.............:"+myBill.getUserId().toString());
      //  billAppService.addBill(billServiceMapper.toBillApiDto(myBill));


//        payment.setBill(myBill);

        paymentServiceApi.savePayment(payment);


        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setRefId(refId);
        return paymentMapper.toPaymentResponseApi(paymentResponseDto);
//        return paymentMapper.toPaymentResponseApi(paymentServiceApi.payBill(paymentRequestDto));
    }

}
