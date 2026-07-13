package com.example.billpayment.service.api.persistence;


import com.example.billpayment.service.dto.user.RegisterUserRequestDto;

public interface UserServiceApi {

    void insertUser(RegisterUserRequestDto user);
    RegisterUserRequestDto findByUsername(String username);

    }
