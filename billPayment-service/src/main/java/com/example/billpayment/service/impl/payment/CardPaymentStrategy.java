package com.example.billpayment.service.impl.payment;

import com.example.billpayment.service.dto.bill.BillServiceDto;
import com.example.billpayment.service.dto.payment.PaymentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardPaymentStrategy implements PaymentStrategy{

    private static final Logger LOGGER= LoggerFactory.getLogger(CardPaymentStrategy.class);

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.CARD;
    }

    @Override
    public void pay(Long billID) {

    LOGGER.info("payment with card with billID: {} ",billID);

    }
}
