package com.example.billpayment.service.api;

import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserAppService {

    void insertUser(RegisterUserRequestApi user);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
