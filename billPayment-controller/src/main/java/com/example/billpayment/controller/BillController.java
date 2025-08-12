package com.example.billpayment.controller;


import com.example.billpayment.api.dto.bill.BillApi;
import com.example.billpayment.api.dto.bill.BillWithUserRequestApi;
import com.example.billpayment.api.facade.BillFacade;
import com.example.billpayment.api.facade.UserFacade;
import com.example.billpayment.service.api.BillAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = UserFacade.PATH)
//@RequiredArgsConstructor
public class BillController implements BillFacade {

    private final BillAppService billAppService;

    public BillController(BillAppService billAppService) {
        this.billAppService = billAppService;
    }


    @Override
    public void addBill(@RequestBody BillApi addBillRequestApi) {
        billAppService.addBill(addBillRequestApi);

    }

    @Override
    public List<BillApi> getBillByUsername(@RequestBody BillWithUserRequestApi billWithUserRequestApi) {
        return billAppService.getBillByUsername(billWithUserRequestApi);
    }

    @Override
    public BillApi getBillByBillId(@RequestBody String billId) {
        return billAppService.getBillByBillId(billId);
    }
}
