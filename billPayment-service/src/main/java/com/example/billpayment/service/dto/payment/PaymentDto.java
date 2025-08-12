package com.example.billpayment.service.dto.payment;


import com.example.billpayment.service.dto.bill.BillServiceDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {

    private String refId;

    private LocalDate paymentDate;

    private BillServiceDto bill;
}
