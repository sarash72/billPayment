package com.example.billpayment.persistence.mapper;


import com.example.billpayment.persistence.entity.Bill;
import com.example.billpayment.persistence.entity.User;
import com.example.billpayment.service.dto.bill.AddBillRequestDto;
import com.example.billpayment.service.dto.user.RegisterUserRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BillMapper {

    Bill toBillEntity(AddBillRequestDto addBillRequestDto);
}
