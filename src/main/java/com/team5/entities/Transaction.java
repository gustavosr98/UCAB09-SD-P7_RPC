package com.team5.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaction")
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

    @Column(name="type")
    private String type;

    @ManyToOne()
    @JoinColumn(name="fk_source_account", nullable=true)
    private Account sourceAccount;

    @ManyToOne()
    @JoinColumn(name="fk_destination_account", nullable=true)
    private Account destinationAccount;

    public Transaction(float amount, Date date, String description, String type, Account sourceAccount, Account destinationAccount) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.type = type;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public Transaction() {
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}