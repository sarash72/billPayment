package com.example.billpayment.persistence.mapper;


import com.example.billpayment.persistence.entity.Bill;
import com.example.billpayment.service.dto.bill.BillServiceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    Bill toBillEntity(BillServiceDto addBillRequestDto);
}
