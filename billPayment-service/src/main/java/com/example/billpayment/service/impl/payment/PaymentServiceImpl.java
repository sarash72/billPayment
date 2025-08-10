package com.example.billpayment.service.impl.payment;

import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentResponseApi;
import com.example.billpayment.service.api.PaymentService;
import com.example.billpayment.service.api.persistence.PaymentServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

   PaymentServiceApi paymentServiceApi;

    @Override
    public PaymentResponseApi payBill(PaymentRequestApi paymentRequestDto) {
        return paymentServiceApi.payBill();
    }
}
