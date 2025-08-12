package com.example.billpayment.api.facade;

import com.example.billpayment.api.dto.user.LoginUserRequestApi;
import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = UserFacade.PATH)
public interface UserFacade {
    String PATH = "/billPayment";

    @PostMapping(value = "register-user",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void insertUser(RegisterUserRequestApi userRequestDto);

    @PostMapping(value = "login-user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Map<String, String>> loginUser(LoginUserRequestApi userRequestDto);
}
