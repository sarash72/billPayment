package com.example.billpayment.service.api;

import com.example.billpayment.api.dto.user.RegisterUserRequestApi;

public interface UserAppService {

    void insertUser(RegisterUserRequestApi user);

}
