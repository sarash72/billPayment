package com.billPayment.bill.api.dto.response;

import com.billPayment.bill.persistence.entity.BillStatus;

import java.math.BigDecimal;

public record BillDetailsResponse(Long id,

                                  String billNumber,

                                  BigDecimal amount,

                                  BillStatus billStatus

//                                  PaymentStatus paymentStatus
) {
}
