package com.intelliarts.bank.service.impl;

import com.intelliarts.bank.dao.BankingOperationRepository;
import com.intelliarts.bank.domain.Expenses;
import com.intelliarts.bank.service.BankingOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

@Service
public class BankingServiceImpl implements BankingOperationService {

    @Autowired
    private BankingOperationRepository bankingOperationRepository;

    @Autowired
    private RestService exchangeService;


    @Override
    public Expenses saveExpenses(Expenses bankingOperation) {
        return bankingOperationRepository.save(bankingOperation);
    }

    @Override
    public List<Expenses> getAllExpenses() {
        return bankingOperationRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    @Transactional
    @Override
    public void deleteByAllDate(String date) {
        bankingOperationRepository.deleteAllByDate(date);
    }

    @Override
    public double getTotalPrice(Currency base) throws IOException {
         List<Expenses> expenses = bankingOperationRepository.findAll();

        Set<Currency> currencies = new LinkedHashSet<>();

        for (Expenses expens : expenses) {
            currencies.add(expens.getCurrency().getCurrency());
        }
        Map<Currency, BigDecimal> exchangeRate = exchangeService.getExchangeRate(base, currencies);

        var total = BigDecimal.ZERO;

        for (Expenses expens : expenses) {
            BigDecimal scale = exchangeRate.get(expens.getCurrency().getCurrency());
            BigDecimal result = BigDecimal.valueOf(expens.getAmount()).divide(scale, MathContext.DECIMAL32);
            total = total.add(result);
        }
        return total.doubleValue();
    }


}
