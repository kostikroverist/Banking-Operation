package com.intelliarts.bank;

import com.intelliarts.bank.dao.BankingOperationRepository;
import com.intelliarts.bank.domain.Currency;
import com.intelliarts.bank.domain.Expenses;
import com.intelliarts.bank.service.BankingOperationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@SpringBootTest
@RunWith(SpringRunner.class)
class BankApplicationTests {

    @Autowired
    private BankingOperationRepository bankingOperationRepository;
    @Autowired
    private BankingOperationService bankingOperationService;


    @Test
    void expensesAddTest() {
        List<Expenses> expensesListBeforeAfter = bankingOperationRepository.findAll();
        assertThat(expensesListBeforeAfter, hasSize(0));

        Expenses expenses = new Expenses();

        expenses.setDate("2021-01-12");
        expenses.setCurrency(Currency.EUR);
        expenses.setAmount(1222.2);
        expenses.setProduct(List.of("car"));

        bankingOperationService.saveExpenses(expenses);

        expensesListBeforeAfter = bankingOperationRepository.findAll();

        assertThat(expensesListBeforeAfter, hasSize(1));
    }

    @Test
    void getAllExpensesTest() {
        List<Expenses> expensesList = bankingOperationService.getAllExpenses();

        assertThat(expensesList, hasSize(1));

    }

    @Test
    void deleteByAllDateTest() {

        Expenses expenses = new Expenses();

        expenses.setDate("2020-12-12");
        expenses.setCurrency(Currency.EUR);
        expenses.setAmount(1222.2);
        expenses.setProduct(List.of("car"));

        bankingOperationService.saveExpenses(expenses);

        assert "2020-12-12".equals(expenses.getDate());

        List<Expenses> expensesList = bankingOperationService.getAllExpenses();
        assertThat(expensesList, hasSize(2));

        bankingOperationService.deleteByAllDate("2020-12-12");

        expensesList = bankingOperationService.getAllExpenses();

        assertThat(expensesList, hasSize(1));
    }

    @Test
    void getTotalPriceTest() {

    }
}
