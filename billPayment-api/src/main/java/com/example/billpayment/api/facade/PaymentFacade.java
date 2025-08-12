package com.example.billpayment.api.facade;

import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentResponseApi;
import com.example.billpayment.api.exception.BillPaidException;
import com.example.billpayment.api.exception.NotFoundBillException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = PaymentFacade.PATH)
public interface PaymentFacade {
    String PATH = "/billPayment";

    @PostMapping(value = "pay-bill",
            produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentResponseApi payBill(PaymentRequestApi paymentRequestApi) throws NotFoundBillException, BillPaidException;

}
