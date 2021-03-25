package com.intelliarts.bank.domain;

public enum Currency {
    UAH("UAH"),
    USD("USD"),
    PLN("PLN"),
    EUR("EUR"),
    GBP("GBP");

    private final java.util.Currency currency;


    Currency(String currencyCode) {
        this.currency = java.util.Currency.getInstance(currencyCode);
    }

    public java.util.Currency getCurrency() {
        return currency;
    }
}
