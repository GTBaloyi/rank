package com.casino.rank.model.response;

import java.math.BigInteger;

public class UpdateBalanceResponse {
    private BigInteger transactionId;
    private double balance;

    public UpdateBalanceResponse(BigInteger transactionId, double balance) {
        this.transactionId = transactionId;
        this.balance = balance;
    }

    public BigInteger getTransactionId() {
        return transactionId;
    }

    public double getBalance() {
        return balance;
    }
}
