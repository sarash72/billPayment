package com.example.billpayment.service.impl.mapper;


import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import com.example.billpayment.service.dto.user.RegisterUserRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface UserServiceMapper {

//    @Mapping(source = "username", target = "username")
//    @Mapping(source = "password", target = "password")
    RegisterUserRequestDto toRegisterUserRequestDto( RegisterUserRequestApi userRequestDto);
}
