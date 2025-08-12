package com.example.billpayment.service.api;

import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentResponseApi;

public interface PaymentService {

    PaymentResponseApi payBill(PaymentRequestApi paymentRequestDto);

}
