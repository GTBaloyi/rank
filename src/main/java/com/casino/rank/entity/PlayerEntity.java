package com.casino.rank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Player")
public class PlayerEntity {
    @Id
    @GeneratedValue()
    private int id;
    private String username;
    private double balance;

    public PlayerEntity( String username, double balance) {
        this.username = username;
        this.balance = balance;
    }

    public PlayerEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
