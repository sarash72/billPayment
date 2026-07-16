package com.billPayment.bill.application.service;

import com.billPayment.bill.application.dto.request.CreateBillRequest;
import com.billPayment.bill.application.dto.response.BillResponse;

import java.util.List;

public interface BillService {

    BillResponse createBill(CreateBillRequest createBillRequest);

    List<BillResponse> getBills();


}
