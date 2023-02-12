package com.casino.rank.model.response;

import com.casino.rank.model.enums.TransactionType;

import java.math.BigInteger;

public class TransactionsResponse {
    private TransactionType transactionType;
    private BigInteger transactionId;
    private double amount;

    public TransactionsResponse(TransactionType transactionType, BigInteger transactionId, double amount) {
        this.transactionType = transactionType;
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigInteger getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }
}
