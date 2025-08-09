package com.example.billpayment.service.api.persistence;


import com.example.billpayment.service.dto.LoginUserRequestDto;
import com.example.billpayment.service.dto.RegisterUserRequestDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface UserServiceApi {

    void insertUser(RegisterUserRequestDto user);
    RegisterUserRequestDto findByUsername(String username);

    }
