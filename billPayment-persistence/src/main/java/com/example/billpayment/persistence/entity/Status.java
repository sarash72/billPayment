package com.example.billpayment.persistence.entity;

public enum Status {

    PAID(0),
    UNPAID(1);

    private int code;

    private Status(int code){
        this.code = code;

    }
    public int getCode() {
        return code;
    }
}
