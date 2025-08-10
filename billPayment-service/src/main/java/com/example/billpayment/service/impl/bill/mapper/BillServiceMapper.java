package com.example.billpayment.service.impl.bill.mapper;


import com.example.billpayment.api.dto.bill.BillApi;
import com.example.billpayment.service.dto.bill.BillServiceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface BillServiceMapper {

//    @Mapping(source = "username", target = "username")
//    @Mapping(source = "password", target = "password")
    BillServiceDto toAddBillRequestDto(BillApi userRequestDto);
}
