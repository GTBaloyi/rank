package com.casino.rank.model.request;

import com.casino.rank.model.enums.TransactionType;

public class UpdateBalanceRequest {
    private double amount;
    private TransactionType transactionType;

    public UpdateBalanceRequest(double amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
