package com.intelliarts.bank.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Expenses {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JsonFormat(pattern = "yyyy=MM-dd",shape = JsonFormat.Shape.STRING)
    @Column
    private String date;

    @Column
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column
    private Currency currency;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> product;


    public Expenses(String date, double amount, Currency currency, List<String> product) {
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.product = product;
    }

    public Expenses() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    @JsonIgnore//todo
    public LocalDate getLocalDate() {
        return LocalDate.parse(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<String> getProduct() {
        return product;
    }

    public void setProduct(List<String> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "date='" + date + '\'' +
                ", amount=" + amount +
                ", currency=" + currency +
                ", product=" + product +
                '}';
    }
}

