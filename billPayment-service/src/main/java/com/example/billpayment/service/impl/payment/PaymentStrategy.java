package com.example.billpayment.service.impl.payment;

import com.example.billpayment.service.dto.bill.BillServiceDto;
import com.example.billpayment.service.dto.payment.PaymentType;

public interface PaymentStrategy {
    PaymentType getPaymentType();

    void pay(String billId);
}
