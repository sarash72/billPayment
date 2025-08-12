package com.example.billpayment.api.facade;

import com.example.billpayment.api.dto.bill.BillApi;
import com.example.billpayment.api.dto.bill.BillWithUserRequestApi;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = BillFacade.PATH)
public interface BillFacade {
    String PATH = "/billPayment";

    @PostMapping(value = "add-bill",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void addBill(BillApi addBillRequestApi);

    @PostMapping(value = "get-bill-byUsername",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    List<BillApi> getBillByUsername(BillWithUserRequestApi billWithUserRequestApi);

    @PostMapping(value = "get-bill-byBillId",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    BillApi getBillByBillId(String billId);

}
