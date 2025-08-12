package com.example.billpayment.service.api;

import com.example.billpayment.api.dto.bill.BillApi;
import com.example.billpayment.api.dto.bill.BillWithUserRequestApi;

import java.util.List;

public interface BillAppService {

    void addBill(BillApi addBillRequestApi);

    List<BillApi> getBillByUsername(BillWithUserRequestApi billWithUserRequestApi);

    BillApi getBillById(Long billId);
}
