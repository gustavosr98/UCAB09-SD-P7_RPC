package com.team5.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="amount")
    private float amount;

    @Column(name= "date")
    private Date date;

    @Column(name="description")
    private String description;

    @Column(name="fk_expense_account")
    private int expenseAccount;

    @Column(name="fk_income_account")
    private int incomeAccount;

    public Transaction(float amount, Date date, String description, int expenseAccount, int incomeAccount) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.expenseAccount = expenseAccount;
        this.incomeAccount = incomeAccount;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExpenseAccount() {
        return expenseAccount;
    }

    public void setExpenseAccount(int expenseAccount) {
        this.expenseAccount = expenseAccount;
    }

    public int getIncomeAccount() {
        return incomeAccount;
    }

    public void setIncomeAccount(int incomeAccount) {
        this.incomeAccount = incomeAccount;
    }
}
