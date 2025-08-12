package com.example.billpayment.service.api.persistence;


import com.example.billpayment.service.dto.bill.BillServiceDto;
import com.example.billpayment.service.dto.bill.BillWithUserRequestDto;
import com.example.billpayment.service.dto.payment.PaymentDto;
import com.example.billpayment.service.dto.payment.PaymentRequestDto;
import com.example.billpayment.service.dto.payment.PaymentResponseDto;

import java.util.List;

public interface PaymentServiceApi {

//    PaymentResponseDto payBill(PaymentRequestDto paymentRequestDto);

    void savePayment(PaymentDto paymentDto);
    }
