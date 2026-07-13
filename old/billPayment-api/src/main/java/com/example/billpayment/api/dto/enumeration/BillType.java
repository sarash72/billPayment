package com.example.billpayment.api.dto.enumeration;


public enum BillType {
    ELECTRICITY(0, "electricity"),
    WATER(1, "water"),
    GAS(2, "gas"),
    INTERNET(3, "internet"),
    MOBILE(4, "mobile"),
    OTHER(5, "other");

    private String value;
    private int code;

    private BillType(int code, String value) {
        this.value = value;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
