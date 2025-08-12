package com.example.billpayment.api.exception;

public class BillPaymentRuntimeException extends RuntimeException {


    public BillPaymentRuntimeException() {
        super(Constant.RUNTIME_EXCEPTION_MESSAGE);
    }

    public BillPaymentRuntimeException(String message) {
        super(message);
    }

    public BillPaymentRuntimeException(Throwable cause) {
        super(Constant.RUNTIME_EXCEPTION_MESSAGE, cause);
    }

    public BillPaymentRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
