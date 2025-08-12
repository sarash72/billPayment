package com.example.billpayment.service.dto.payment;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestDto {

   private String billId;
   private PaymentType paymentType;
}
