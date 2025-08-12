package com.example.billpayment.persistence.mapper;


import com.example.billpayment.persistence.entity.Bill;
import com.example.billpayment.persistence.entity.Payment;
import com.example.billpayment.service.dto.bill.BillServiceDto;
import com.example.billpayment.service.dto.payment.PaymentDto;
import com.example.billpayment.service.dto.payment.PaymentRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

 Payment toPaymentEntity(PaymentDto paymentDto);

}
