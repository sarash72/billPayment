package com.billPayment.bill.application.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateBillRequest(BigDecimal amount,

                                LocalDate dueDate) {
}
