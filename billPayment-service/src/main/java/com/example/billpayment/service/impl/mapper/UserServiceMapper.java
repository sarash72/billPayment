package com.example.billpayment.service.impl.mapper;


import com.example.billpayment.api.dto.RegisterUserRequestApi;
import com.example.billpayment.service.dto.RegisterUserRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" )
public interface UserServiceMapper {

//    @Mapping(source = "username", target = "username")
//    @Mapping(source = "password", target = "password")
    RegisterUserRequestDto toRegisterUserRequestDto( RegisterUserRequestApi userRequestDto);
}
