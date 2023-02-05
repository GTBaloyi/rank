package com.casino.rank.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Transaction")
public class TransactionEntity {
    @Id
    private int id;
    private String type;
    private double amount;

    public TransactionEntity(int id, String type, double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
