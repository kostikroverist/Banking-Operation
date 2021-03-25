package com.intelliarts.bank.service.impl;

import com.intelliarts.bank.dto.OuterExchange;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestService {

    private static final String BASE_URL = "https://api.exchangerate.host/latest";

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Map<Currency, BigDecimal> getExchangeRate(Currency base, Collection<Currency> interestingCurrencies) {
        Map<String, Object> params = new HashMap<>();
        params.put("base", base.getCurrencyCode());
        Map<Currency, BigDecimal> ratesWithTypes = restTemplate.getForEntity(BASE_URL, OuterExchange.class, params).getBody().getRatesWithTypes();
        return ratesWithTypes;
    }

    public String getPostsPlainJSON() {

        System.out.println(this.restTemplate.getForObject(BASE_URL, String.class));
        return this.restTemplate.getForObject(BASE_URL, String.class);
    }
}
