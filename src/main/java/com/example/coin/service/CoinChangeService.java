package com.example.coin.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CoinChangeService {
    /**
     * Calculate the minimum coin combination for the given amount and denominations.
     * @param amount Target amount
     * @param coins List of available coin denominations
     * @return Minimum coin combination in ascending order, or empty list if not possible
     */
    public List<Double> minCoinChange(double amount, List<Double> coins) {
        // Convert amount and denominations to cents to avoid floating point errors
        int target = (int)Math.round(amount * 100);
        List<Integer> coinInts = new ArrayList<>();
        for (double c : coins) {
            coinInts.add((int)Math.round(c * 100));
        }
        Collections.sort(coinInts);

        int[] dp = new int[target + 1];
        int[] pre = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int coin : coinInts) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    if (dp[i - coin] + 1 < dp[i]) {
                        dp[i] = dp[i - coin] + 1;
                        pre[i] = coin;
                    }
                }
            }
        }

        if (dp[target] == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }

        // Backtrack to get the coin combination
        List<Double> result = new ArrayList<>();
        int curr = target;
        while (curr > 0) {
            int coin = pre[curr];
            result.add(coin / 100.0);
            curr -= coin;
        }
        Collections.sort(result);
        return result;
    }
}