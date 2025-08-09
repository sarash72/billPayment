package com.example.billpayment.persistence.mapper;


import com.example.billpayment.persistence.entity.User;
import com.example.billpayment.service.dto.RegisterUserRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUserEntity(final RegisterUserRequestDto userRequestDto);

    //    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    RegisterUserRequestDto toRegisterUserRequestDto( User user);
}
