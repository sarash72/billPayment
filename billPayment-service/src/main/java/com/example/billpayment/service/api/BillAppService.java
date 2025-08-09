package com.example.billpayment.service.api;

import com.example.billpayment.api.dto.bill.AddBillRequestApi;
import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import com.example.billpayment.service.dto.bill.AddBillRequestDto;

public interface BillAppService {

    void addBill(AddBillRequestApi addBillRequestApi);

}
