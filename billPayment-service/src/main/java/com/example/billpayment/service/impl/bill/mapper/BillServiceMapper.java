package com.example.billpayment.service.impl.bill.mapper;


import com.example.billpayment.api.dto.bill.BillApi;
import com.example.billpayment.api.dto.bill.BillWithUserRequestApi;
import com.example.billpayment.service.dto.bill.BillServiceDto;
import com.example.billpayment.service.dto.bill.BillWithUserRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillServiceMapper {

    BillServiceDto toBillRequestDto(BillApi billApi);

    BillWithUserRequestDto toBillWithUserRequestDto(BillWithUserRequestApi billWithUserRequestApi);

    List<BillApi> toBillApiDtoList(List<BillServiceDto> billServiceDtoList);

    BillApi toBillApiDto(BillServiceDto billServiceDto);

}

