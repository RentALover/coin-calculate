package com.example.coin.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeServiceTest {
    private final CoinChangeService service = new CoinChangeService();

    @Test
    void testExample1() {
        double amount = 7.03;
        List<Double> coins = Arrays.asList(0.01, 0.5, 1.0, 5.0, 10.0);
        List<Double> expected = Arrays.asList(0.01, 0.01, 0.01, 1.0, 5.0);
        List<Double> result = service.minCoinChange(amount, coins);
        assertEquals(expected, result);
    }

    @Test
    void testExample2() {
        double amount = 103.0;
        List<Double> coins = Arrays.asList(1.0, 2.0, 50.0);
        List<Double> expected = Arrays.asList(1.0, 2.0, 50.0, 50.0);
        List<Double> result = service.minCoinChange(amount, coins);
        assertEquals(expected, result);
    }

    @Test
    void testNoSolution() {
        double amount = 3.0;
        List<Double> coins = Arrays.asList(2.0, 5.0);
        List<Double> expected = Collections.emptyList();
        List<Double> result = service.minCoinChange(amount, coins);
        assertEquals(expected, result);
    }

    @Test
    void testZeroAmount() {
        double amount = 0.0;
        List<Double> coins = Arrays.asList(0.01, 0.5, 1.0);
        List<Double> expected = Collections.emptyList();
        List<Double> result = service.minCoinChange(amount, coins);
        assertEquals(expected, result);
    }
} 