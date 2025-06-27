package com.example.coin.dto;

import java.util.List;

public class CoinChangeRequest {
    private double amount;
    private List<Double> coins;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Double> getCoins() {
        return coins;
    }

    public void setCoins(List<Double> coins) {
        this.coins = coins;
    }
} 