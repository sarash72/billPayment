package com.example.billpayment.service.api.persistence;


import com.example.billpayment.service.dto.bill.BillServiceDto;
import com.example.billpayment.service.dto.bill.BillWithUserRequestDto;

import java.util.List;

public interface BillServiceApi {

    void addBill(BillServiceDto addBillRequestDto);

    List<BillServiceDto> getBillByUsername(BillWithUserRequestDto billWithUserRequestDto);

    BillServiceDto getBillByBillId(String billId);

}
