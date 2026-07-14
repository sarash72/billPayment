package com.billPayment.bill.service;

import com.billPayment.bill.api.dto.request.CreateBillRequest;
import com.billPayment.bill.api.dto.response.BillResponse;

import java.util.List;

public interface BillService {

    BillResponse createBill(CreateBillRequest createBillRequest);

    List<BillResponse> getBills();


}
