package com.example.billpayment.service.dto.bill;

import com.example.billpayment.api.dto.enumeration.BillType;
import com.example.billpayment.api.dto.enumeration.Status;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillServiceDto {

    private BillType billType; // مثلا برق، آب، گاز

    private String billTd;

    private BigDecimal amount;

    private LocalDate dueDate;

    private Status status;

    private Long userId;

}
