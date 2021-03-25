package com.intelliarts.bank.dao;

import com.intelliarts.bank.domain.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankingOperationRepository extends JpaRepository<Expenses, Long>{

    List<Expenses> deleteAllByDate(String date);

}
