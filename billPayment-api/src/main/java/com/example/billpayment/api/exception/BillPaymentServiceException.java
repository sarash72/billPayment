package com.example.billpayment.api.exception;

public class BillPaymentServiceException extends Exception{

    public BillPaymentServiceException(String message) {
        super(message);
    }

    public BillPaymentServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
