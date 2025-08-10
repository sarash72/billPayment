package com.example.billpayment.service.impl.payment;

import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentResponseApi;
import com.example.billpayment.service.api.PaymentService;
import com.example.billpayment.service.api.persistence.PaymentServiceApi;
import com.example.billpayment.service.impl.payment.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    PaymentServiceApi paymentServiceApi;
    PaymentMapper paymentMapper;

    @Override
    public PaymentResponseApi payBill(PaymentRequestApi paymentRequestDto) {
        return paymentMapper.toPaymentResponseApi(paymentServiceApi.payBill(paymentMapper.toPaymentRequestDto(paymentRequestDto)));
    }
}
