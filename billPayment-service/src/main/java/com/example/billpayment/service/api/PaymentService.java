package com.example.billpayment.service.api;

import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentResponseApi;
import com.example.billpayment.api.exception.BillPaidException;
import com.example.billpayment.api.exception.NotFoundBillException;

public interface PaymentService {

    PaymentResponseApi payBill(PaymentRequestApi paymentRequestDto) throws BillPaidException, NotFoundBillException;

}
