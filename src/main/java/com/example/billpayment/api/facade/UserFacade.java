package com.example.billpayment.api.facade;

import com.example.billpayment.api.dto.UserRequestDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

public interface UserFacade {
    String PATH = "/billPayment";

    @PostMapping(value = "register-user" ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    void insertUser(UserRequestDto userRequestDto);
}
