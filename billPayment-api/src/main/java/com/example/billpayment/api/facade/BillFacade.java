package com.example.billpayment.api.facade;

import com.example.billpayment.api.dto.bill.AddBillRequestApi;
import com.example.billpayment.api.dto.user.LoginUserRequestApi;
import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = BillFacade.PATH)
public interface BillFacade {
    String PATH = "/billPayment";

    @PostMapping(value = "add-bill",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void addBill(AddBillRequestApi addBillRequestApi);

}
