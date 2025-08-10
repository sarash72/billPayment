package com.example.billpayment.controller;


import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentResponseApi;
import com.example.billpayment.api.facade.PaymentFacade;
import com.example.billpayment.api.facade.UserFacade;
import com.example.billpayment.service.api.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = UserFacade.PATH)
//@RequiredArgsConstructor
public class PaymentController implements PaymentFacade {

   private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public PaymentResponseApi payBill(PaymentRequestApi paymentRequestApi) {
        return paymentService.payBill(paymentRequestApi);
    }
}
