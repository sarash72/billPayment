package com.billPayment.bill.api.dto.request;

import com.billPayment.bill.persistence.entity.BillStatus;
import com.billPayment.bill.persistence.entity.BillType;

public record BillSearchRequest(BillType billType,

                                BillStatus status,

                                Long userId) {
}
