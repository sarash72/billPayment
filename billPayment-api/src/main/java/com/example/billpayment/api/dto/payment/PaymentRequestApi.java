package com.example.billpayment.api.dto.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "PaymentRequestApi", description = "Payment  service")
public class PaymentRequestApi {

   private String billId;

   private PaymentType paymentType;
}
