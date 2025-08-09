package com.example.billpayment.persistence.entity;



public enum BillType {
    ELECTRICITY("electricity"),
    WATER("water"),
    GAS("gas"),
    INTERNET("internet"),
    MOBILE("mobile"),
    OTHER("other");

    private String value;

    private BillType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
