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
    public static float findMaxProfit(List<StockOption> stockOptions) {
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

}
