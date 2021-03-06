package com.team5.entities;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="current_balance", nullable=false)
    private float currentBalance;

    @ManyToOne()
    @JoinColumn(name="fk_user", nullable=false, referencedColumnName = "id")
    private UserBank userBank;

    @OneToMany(mappedBy="sourceAccount")
    private List<Transaction> expenseTransactions;

    @OneToMany(mappedBy="destinationAccount")
    private List<Transaction> incomeTransactions;

    public Account(float currentBalance, UserBank userBank) {
        this.currentBalance = currentBalance;
        this.userBank = userBank;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public UserBank getUser() {
        return userBank;
    }

    public void setUser(UserBank userBank) {
        this.userBank = userBank;
    }
}
