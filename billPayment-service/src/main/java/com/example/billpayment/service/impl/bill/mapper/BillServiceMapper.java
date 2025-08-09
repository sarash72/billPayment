package com.example.billpayment.service.impl.bill.mapper;


import com.example.billpayment.api.dto.bill.AddBillRequestApi;
import com.example.billpayment.api.dto.user.RegisterUserRequestApi;
import com.example.billpayment.service.dto.bill.AddBillRequestDto;
import com.example.billpayment.service.dto.user.RegisterUserRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface BillServiceMapper {

//    @Mapping(source = "username", target = "username")
//    @Mapping(source = "password", target = "password")
    AddBillRequestDto toAddBillRequestDto(AddBillRequestApi userRequestDto);
}
