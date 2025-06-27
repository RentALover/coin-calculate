package com.example.coin.controller;

import com.example.coin.dto.CoinChangeRequest;
import com.example.coin.service.CoinChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coin-change")
public class CoinChangeController {
    @Autowired
    private CoinChangeService coinChangeService;

    @PostMapping
    public List<Double> getMinCoinChange(@RequestBody CoinChangeRequest request) {
        return coinChangeService.minCoinChange(request.getAmount(), request.getCoins());
    }
} 