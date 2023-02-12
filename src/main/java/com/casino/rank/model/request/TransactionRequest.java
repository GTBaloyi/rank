package com.casino.rank.model.request;

public class TransactionRequest {
    private String username;

    public TransactionRequest(String username) {
        this.username = username;
    }

    public TransactionRequest() {
    }

    public String getUsername() {
        return username;
    }


}
