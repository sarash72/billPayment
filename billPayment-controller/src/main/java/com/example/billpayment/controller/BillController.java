package com.example.billpayment.controller;


import com.example.billpayment.api.dto.bill.AddBillRequestApi;
import com.example.billpayment.api.dto.user.LoginUserRequestApi;
import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import com.example.billpayment.api.facade.BillFacade;
import com.example.billpayment.api.facade.UserFacade;
import com.example.billpayment.service.api.BillAppService;
import com.example.billpayment.service.api.UserAppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void addBill(@RequestBody AddBillRequestApi addBillRequestApi) {
        billAppService.addBill(addBillRequestApi);

    }
}
