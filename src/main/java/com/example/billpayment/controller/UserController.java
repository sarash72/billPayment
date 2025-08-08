package com.example.billpayment.controller;


import com.example.billpayment.api.dto.UserRequestDto;
import com.example.billpayment.api.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path=UserController.PATH)
public class UserController implements UserFacade {


    @Override
    public void insertUser(UserRequestDto userRequestDto) {

    }
}
