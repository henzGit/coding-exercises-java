package com.leet_code;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int minBuyFirst = Integer.MAX_VALUE;
        int minBuySecond = Integer.MAX_VALUE;
        int profitFirst = 0;
        int profitSecond = 0;

        for(int i = 0; i < prices.length; i++){
            minBuyFirst = Math.min(minBuyFirst, prices[i]);
            profitFirst = Math.max(profitFirst, prices[i] - minBuyFirst < 0 ? 0: prices[i] - minBuyFirst);
            minBuySecond = Math.min(minBuySecond, prices[i] - profitFirst);
            profitSecond = Math.max(profitSecond, prices[i] - minBuySecond);
        }

        return profitSecond;
    }
}
