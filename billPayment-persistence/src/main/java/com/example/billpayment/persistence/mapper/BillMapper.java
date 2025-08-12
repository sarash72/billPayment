package com.example.billpayment.persistence.mapper;


import com.example.billpayment.persistence.entity.Bill;
import com.example.billpayment.service.dto.bill.BillServiceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillMapper {

    Bill toBillEntity(BillServiceDto addBillRequestDto);
    List<BillServiceDto> toBillDtoList(List<Bill> billList);
    BillServiceDto toBillDto(Bill bill);

}
