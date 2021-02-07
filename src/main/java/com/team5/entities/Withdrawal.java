package com.team5.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Withdrawal extends Transaction {
    public Withdrawal(float amount, Date date, String description, int expenseAccount, int incomeAccount) {
        super(amount, date, description, expenseAccount, incomeAccount);
    }
}
