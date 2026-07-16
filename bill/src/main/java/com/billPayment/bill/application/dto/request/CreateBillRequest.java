package com.billPayment.bill.application.dto.request;

import com.billPayment.bill.persistence.entity.BillType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateBillRequest(Long userId,

                                String billNumber,

                                BillType billType,

                                BigDecimal amount,

                                LocalDate dueDate) {


}
