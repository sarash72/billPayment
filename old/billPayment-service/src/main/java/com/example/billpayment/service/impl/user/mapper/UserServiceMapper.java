package com.example.billpayment.service.impl.user.mapper;


import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import com.example.billpayment.service.dto.user.RegisterUserRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface UserServiceMapper {


    RegisterUserRequestDto toRegisterUserRequestDto( RegisterUserRequestApi userRequestDto);
}
