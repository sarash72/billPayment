package com.example.billpayment.service.impl.payment;

import com.example.billpayment.service.dto.payment.PaymentType;

public class PaymentFactory {

    public static PaymentStrategy getPaymentStrategy(PaymentType paymentType) {
        switch (paymentType) {

            case CARD -> {
                return new CardPaymentStrategy();
            }
            case WALLET -> {
                return new WalletPaymentStrategy();
            }
            default -> throw new IllegalArgumentException("Invalid payment type");
        }
    }
}
