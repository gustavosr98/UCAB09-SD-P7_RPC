package com.team5.entities;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="document_id")
    private String documentId;

    @Column(name= "name")
    private String name;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public User(String documentId, String name, String username, String password) {
        this.documentId = documentId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    @Id
    public int getId() {
        return id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
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
