package com.example.billpayment.api.dto.bill;

import com.example.billpayment.api.dto.enumeration.BillType;
import com.example.billpayment.api.dto.enumeration.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "addBill", description = "add bill service")
public class BillApi {

    private BillType billType; // مثلا برق، آب، گاز

    private String billId;

    private BigDecimal amount;

    private LocalDate dueDate;

    private Status status;

    private Long userId;

}
