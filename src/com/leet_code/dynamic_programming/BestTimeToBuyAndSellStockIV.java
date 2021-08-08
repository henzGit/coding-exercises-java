package com.leet_code.dynamic_programming;

/**
 * You are given an integer array prices where prices[i] is the price of
 * a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int K, int[] prices) {
        int N = prices.length;
        int[][] dp = new int[K + 1][N + 1];
        // dp store profit at Kth transaction on ith day
        for(int k = 1; k <= K; k++) {
            int minBuy = Integer.MAX_VALUE;
            for(int i = 1; i <= N; i++) {
                // min value if we buy today using previous transaction profit
                minBuy = Math.min(minBuy, prices[i - 1] - dp[k - 1][i-1]);
                // max of todays profit or previous day
                dp[k][i] = Math.max(dp[k][i - 1], prices[i - 1] - minBuy);
            }

        }
        return dp[K][N];
    }
}
