package com.example.billpayment.api.exception;

public class NotFoundBillException extends BillPaymentServiceException {


    public NotFoundBillException() {
        super(Constant.BILL_NOT_FOUND_EXCEPTION_MESSAGE);
    }

    public NotFoundBillException(Throwable cause) {
        super(Constant.BILL_NOT_FOUND_EXCEPTION_MESSAGE, cause);
    }
}
