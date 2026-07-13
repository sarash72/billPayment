package com.example.billpayment.service.impl.payment;

import com.example.billpayment.service.dto.bill.BillServiceDto;
import com.example.billpayment.service.dto.payment.PaymentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WalletPaymentStrategy implements PaymentStrategy{

    private static final Logger LOGGER= LoggerFactory.getLogger(WalletPaymentStrategy.class);

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.WALLET;
    }

    @Override
    public void pay(String billId) {

    LOGGER.info("payment with wallet with billId: {}", billId);

    }
}
