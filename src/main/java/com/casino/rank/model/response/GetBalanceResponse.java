package com.casino.rank.model.response;

public class GetBalanceResponse {
    private int playerId;
    private double balance;

    public GetBalanceResponse(int playerId, double balance) {
        this.playerId = playerId;
        this.balance = balance;
    }

    public int getPlayerId() {
        return playerId;
    }

    public double getBalance() {
        return balance;
    }
}
