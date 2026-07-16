package com.billPayment.bill.application.dto.response;

import com.billPayment.bill.persistence.entity.BillStatus;

import java.math.BigDecimal;

public record BillSummaryResponse(Long id,

                                  String billNumber,

                                  BigDecimal amount,

                                  BillStatus status) {
}
