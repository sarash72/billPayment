package com.billPayment.bill.application.serviceImpl;


import com.billPayment.bill.application.dto.request.CreateBillRequest;
import com.billPayment.bill.application.dto.response.BillResponse;
import com.billPayment.bill.application.mapper.BillMapper;
import com.billPayment.bill.application.service.BillService;
import com.billPayment.bill.persistence.entity.Bill;
import com.billPayment.bill.persistence.entity.BillStatus;
import com.billPayment.bill.persistence.repository.BillRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;
    private final BillMapper billMapper;


    @Override
    public BillResponse createBill(CreateBillRequest createBillRequest) {

        Bill bill = billMapper.createBillRequestToBill(createBillRequest);
        bill.setBillStatus(BillStatus.CREATED);
        return billMapper.billToBillResponse(billRepository.save(bill));
    }

    @Override
    public List<BillResponse> getBills() {

        return billMapper.billListToBillResponseList(billRepository.findAll());
    }


}
