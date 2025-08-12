package com.example.billpayment.api.exception;

public class BillPaidException extends BillPaymentServiceException {


    public BillPaidException() {
        super(Constant.BILL_PAID_EXCEPTION_MESSAGE);
    }

    public BillPaidException(Throwable cause) {
        super(Constant.BILL_PAID_EXCEPTION_MESSAGE, cause);
    }
}
