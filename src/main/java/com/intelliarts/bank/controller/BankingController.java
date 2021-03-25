package com.intelliarts.bank.controller;


import com.intelliarts.bank.domain.Expenses;
import com.intelliarts.bank.service.BankingOperationService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@RestController
public class BankingController {


    private final BankingOperationService bankingService;

    public BankingController(BankingOperationService bankingService) {
        this.bankingService = bankingService;
    }

    @PostMapping("/expenses")
    public Expenses saveExpenses(@RequestBody Expenses expenses){
       return bankingService.saveExpenses(expenses);
    }

    @GetMapping("/expenses")
    public  List<Expenses>  allExpenses(){
        return bankingService.getAllExpenses();
    }
    @DeleteMapping("/expenses/{date}")
    public void deleteAllExpenses(@PathVariable("date") String date){
        bankingService.deleteByAllDate(date);
    }

    @GetMapping("/total")
    public BigDecimal totalExpenses(@RequestParam("base") String base) throws IOException {
        Currency currency = Currency.getInstance(base);
        return bankingService.getTotalPrice(currency);
    }

}
