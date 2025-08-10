package com.example.billpayment.service.impl.payment.mapper;


import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.service.dto.payment.PaymentRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface PaymentServiceMapper {

    PaymentRequestDto topaPaymentRequestDto(PaymentRequestApi paymentRequestApi);

}

