package com.billPayment.bill.service;


import com.billPayment.bill.api.dto.request.CreateBillRequest;
import com.billPayment.bill.api.dto.response.BillResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BillServiceImpl implements BillService {

    @Override
    public BillResponse createBill(CreateBillRequest createBillRequest) {
        return null;
    }

    @Override
    public List<BillResponse> getBills() {
        return List.of();
    }
}
