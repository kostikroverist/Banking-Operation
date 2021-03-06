package com.intelliarts.bank.service;


import com.intelliarts.bank.domain.Expenses;

import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.Currency;
import java.util.List;

public interface BankingOperationService {

    Expenses saveExpenses(Expenses expenses);

    List<Expenses> getAllExpenses();

    void deleteByAllDate(String date);

    BigDecimal getTotalPrice(Currency base) throws IOException;
}
