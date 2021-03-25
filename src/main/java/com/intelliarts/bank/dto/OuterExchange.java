package com.intelliarts.bank.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OuterExchange {
    private Map<Currency, BigDecimal> rates;

    public Map<Currency, BigDecimal> getRatesWithTypes() {
        return rates;
    }

    @JsonSetter
    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = convert(rates);
    }

    public OuterExchange() {
    }

    private  Map<Currency, BigDecimal> convert(Map<String, BigDecimal> rates) {
        Map<Currency, BigDecimal> map = new HashMap<>();

        Set<String> keys = rates.keySet();
        for (String key : keys) {
            try {
                BigDecimal rate = rates.get(key);
                Currency currency = Currency.getInstance(key);
                map.put(currency , rate);
                // we ignore unknown currencies
           }catch (IllegalArgumentException ignored){}
        }
        return map;
    }

}
