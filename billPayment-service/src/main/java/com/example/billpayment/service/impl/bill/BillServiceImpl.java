package com.example.billpayment.service.impl.bill;

import com.example.billpayment.api.dto.bill.BillApi;
import com.example.billpayment.api.dto.bill.BillWithUserRequestApi;
import com.example.billpayment.service.api.BillAppService;
import com.example.billpayment.service.api.persistence.BillServiceApi;
import com.example.billpayment.service.impl.bill.mapper.BillServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class BillServiceImpl implements BillAppService {

    private final BillServiceApi billServiceApi;
    private final BillServiceMapper billServiceMapper;

    public BillServiceImpl(BillServiceApi billServiceApi, BillServiceMapper billServiceMapper) {
        this.billServiceApi = billServiceApi;
        this.billServiceMapper = billServiceMapper;
    }

    @Override
    public void addBill(BillApi addBillRequestApi) {
        billServiceApi.addBill(billServiceMapper.toBillRequestDto(addBillRequestApi));
    }

    @Override
    public List<BillApi> getBillByUsername(BillWithUserRequestApi billWithUserRequestApi) {
        return billServiceMapper.toBillApiDtoList(billServiceApi.getBillByUsername(billServiceMapper.toBillWithUserRequestDto(billWithUserRequestApi)));
    }

    @Override
    public BillApi getBillById(Long billId) {
        return null;
    }
}

