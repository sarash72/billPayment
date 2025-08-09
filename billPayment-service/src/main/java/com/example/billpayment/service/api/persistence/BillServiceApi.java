package com.example.billpayment.service.api.persistence;


import com.example.billpayment.service.dto.bill.AddBillRequestDto;
import com.example.billpayment.service.dto.user.RegisterUserRequestDto;

public interface BillServiceApi {

    void addBill(AddBillRequestDto addBillRequestDto);

    }
