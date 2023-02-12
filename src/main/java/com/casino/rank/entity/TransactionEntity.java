package com.casino.rank.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    @JoinColumn(referencedColumnName ="id",name ="playerId")
    private PlayerEntity playerId;
    private String type;
    private double amount;
    @CreationTimestamp
    private Date lastModified;

    public PlayerEntity getPlayerId() {
        return playerId;
    }

    public void setPlayerId(PlayerEntity playerId) {
        this.playerId = playerId;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public TransactionEntity(PlayerEntity playerEntity,String type, double amount) {
        this.playerId = playerEntity;
        this.type = type;
        this.amount = amount;
    }

    public TransactionEntity() {
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
