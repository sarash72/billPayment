package com.example.billpayment.service.impl.payment.mapper;


import com.example.billpayment.api.dto.payment.PaymentRequestApi;
import com.example.billpayment.api.dto.payment.PaymentResponseApi;
import com.example.billpayment.service.dto.payment.PaymentRequestDto;
import com.example.billpayment.service.dto.payment.PaymentResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface PaymentMapper {

    PaymentRequestDto toPaymentRequestDto(PaymentRequestApi paymentRequestApi);
    PaymentResponseApi toPaymentResponseApi(PaymentResponseDto paymentResponseDto);
}

