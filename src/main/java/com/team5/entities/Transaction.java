package com.team5.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    enum Type {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFERENCE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="amount", nullable=false)
    private float amount;

    @Column(name= "date", nullable=false)
    private Date date;

    @Column(name="description", nullable=false)
    private String description;

    @Column(name="type", nullable=false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne()
    @JoinColumn(name="fk_source_account", nullable=true)
    private Account sourceAccount;

    @ManyToOne()
    @JoinColumn(name="fk_destination_account", nullable=true)
    private Account destinationAccount;

    public Transaction(float amount, Date date, String description, Type type, Account sourceAccount, Account destinationAccount) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.type = type;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public static Transaction createDeposit(float amount,String description, Account sourceAccount) {
        Transaction dep = new Transaction();
        dep.amount = amount;
        dep.date = new Date();
        dep.description = description;
        dep.type = Type.DEPOSIT;
        dep.sourceAccount = sourceAccount;
        dep.destinationAccount = null;

        return dep;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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
