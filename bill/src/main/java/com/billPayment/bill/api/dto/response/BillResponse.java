package com.billPayment.bill.api.dto.response;

import com.billPayment.bill.persistence.entity.BillStatus;
import com.billPayment.bill.persistence.entity.BillType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BillResponse (Long id,

                            String billNumber,

                            BillType billType,

                            BigDecimal amount,

                            LocalDate dueDate,

                            BillStatus status,

                            Long userId){
}
