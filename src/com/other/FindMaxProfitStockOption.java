package com.other;

import java.util.List;
import java.time.LocalDateTime;

/**
 * Public class used to find max profit given values of a stock option in time
 */
public class FindMaxProfitStockOption {

    public static class StockOption {
        private int price; // price of a stock option in Japanese Yen
        private LocalDateTime time; // the time where the price takes place

        public StockOption(float value, LocalDateTime time) {
            this.price = (int)value;
            this.time = time;
        }

        public float getPrice() {return this.price;}

        @Override
        public String toString() {
            return String.format("(price: %s)", price);
        }
    }

    /**
     * Find max profit given a list of stock option prices in time
     * @param stockOptions list of stock option prices in time
     * @return max profit
     */
    public static float findMaxProfitFromStockOptions(List<StockOption> stockOptions) {
        float maxProfit = 0.0f;
        float minPrice = 10000.0f;

        for (StockOption stockOption: stockOptions) {
            float currStockPrice = stockOption.getPrice();
            float currentMaxProfit = currStockPrice - minPrice;
            if (currentMaxProfit > maxProfit) {
                maxProfit = currentMaxProfit;
            }
            if (currStockPrice < minPrice) {
                minPrice = currStockPrice;
            }
        }

        return maxProfit;
    }

    /**
     * Returns maximum profit with two transactions on a given
     * list of stock prices, price[0..n-1]
     * @param price array of prices in linear time
     * @return max profit
     */
    public static int maxProfitTwoTransactions(int price[])
    {
        int n = price.length;

        // Create profit array and initialize it as 0
        int profit[] = new int[n];
        for (int i = 0; i < n; i++)
            profit[i] = 0;

		/* Get the maximum profit with only one transaction
		allowed. After this loop, profit[i] contains maximum
		profit from price[i..n-1] using at most one trans. */
        int maxPrice = price[n-1];
        for (int i = n-2; i >= 0; i--)
        {
            // max_price has maximum of price[i..n-1]
            if (price[i] > maxPrice)
                maxPrice = price[i];

            // we can get profit[i] by taking maximum of:
            // a) previous maximum, i.e., profit[i+1]
            // b) profit by buying at price[i] and selling at
            // maxPrice
            profit[i] = Math.max(profit[i+1], maxPrice - price[i]);
        }

		/* Get the maximum profit with two transactions allowed
		After this loop, profit[n-1] contains the result */
        int minPrice = price[0];
        for (int i = 1; i < n; i++)
        {
            // minPrice is minimum price in price[0..i]
            if (price[i] < minPrice)
                minPrice = price[i];

            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and add
            // profit of other trans. stored in profit[i]
            profit[i] = Math.max(profit[i-1], profit[i] + (price[i] - minPrice));
        }
        int result = profit[n-1];
        return result;
    }

}
