package com.team5.entities;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_bank")
public class UserBank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="document_id")
    private int documentId;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="username", nullable=false, unique=true)
    private String username;

    @Column(name="password", nullable=false)
    private String password;

    @OneToMany(mappedBy="userBank")
    private List<Account> accounts;

    public UserBank(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
