package com.example.billpayment.service.impl;

import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import com.example.billpayment.service.api.UserAppService;
import com.example.billpayment.service.api.persistence.UserServiceApi;
import com.example.billpayment.service.dto.user.MyUserDetails;
import com.example.billpayment.service.dto.user.RegisterUserRequestDto;
import com.example.billpayment.service.impl.mapper.UserServiceMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class UserServiceImpl implements UserAppService, UserDetailsService {

    private final UserServiceApi userServiceApi;
    private final UserServiceMapper userMapper;

    public UserServiceImpl(UserServiceApi userServiceApi, UserServiceMapper userMapper) {
        this.userServiceApi = userServiceApi;
        this.userMapper = userMapper;
    }


    @Override
    public void insertUser(RegisterUserRequestApi user) {
        userServiceApi.insertUser(userMapper.toRegisterUserRequestDto(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RegisterUserRequestDto user = userServiceApi.findByUsername(username);
        return new MyUserDetails(user);
    }
}

