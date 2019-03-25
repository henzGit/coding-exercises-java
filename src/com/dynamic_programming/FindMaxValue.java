package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

/**
 * Public class used to find max profit given values of a stock option in time
 */
public class FindMaxValue {

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
    public static float maxProfitStockOptions(List<StockOption> stockOptions) {
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
     * Returns maximum profit with maximum two transactions on a given
     * list of stock prices, price[0..n-1]
     * @param price array of prices in linear time
     * @return max profit
     */
    public static int maxProfitWithMaxTwoTransactions(int price[])
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

    /**
     * Given a list of integers which can be either zero or negative value
     * find the maximum value as the result of multiplication of three integers
     * @return maximum products of three integers multiplication
     */
    public static int findMaxProductsThreeInts(int[] inputInts) {
        int highestProduct = -1000000000;

        boolean zeroExist = false;
        // three integers with max positive value
        List<Integer> maxPositiveValues = new ArrayList<>();

        // three integers with min positive value
        List<Integer> minPositiveValues = new ArrayList<>();

        // three integers with max negative value
        List<Integer> maxNegativeValues = new ArrayList<>();

        // three integers with min negative value
        List<Integer> minNegativeValues = new ArrayList<>();

        // if input integers is not enough
        if (inputInts.length < 3) {
            return -1;
        }

        // if only 3 values exist
        if (inputInts.length == 3) {
            return inputInts[0] * inputInts[1] * inputInts[2];
        }

        // categorize input integers
        for (int currInt: inputInts) {
            if (currInt == 0) {
                zeroExist = true;
            } else if (currInt > 0) {
                maxPositiveValues.add(currInt);
                minPositiveValues.add(currInt);
                Collections.sort(maxPositiveValues, Collections.reverseOrder());
                Collections.sort(minNegativeValues);

                if (maxPositiveValues.size() >= 3) {
                    List<Integer> tmpList = maxPositiveValues.subList(0, 3);
                    maxPositiveValues = tmpList;
                }
                if (minPositiveValues.size() >= 3) {
                    List<Integer> tmpList = minPositiveValues.subList(0, 3);
                    minPositiveValues = tmpList;
                }
            } else if (currInt < 0) {
                maxNegativeValues.add(currInt);
                minNegativeValues.add(currInt);
                Collections.sort(maxNegativeValues);
                Collections.sort(minNegativeValues, Collections.reverseOrder());

                if (maxNegativeValues.size() >= 3) {
                    List<Integer> tmpList = maxNegativeValues.subList(0, 3);
                    maxNegativeValues = tmpList;

                }
                if (minNegativeValues.size() >= 3) {
                    List<Integer> tmpList = minNegativeValues.subList(0, 3);
                    minNegativeValues = tmpList;
                }
            }
        }

        // two possibilities to have max positive value
        // 1) max pos * second max pos * third max pos
        if (maxPositiveValues.size() == 3) {
            highestProduct = maxPositiveValues.get(0) *
                    maxPositiveValues.get(1) * maxPositiveValues.get(2);
        }
        // 2) max pos * max neg * second max neg
        if (maxPositiveValues.size() >= 1 && maxNegativeValues.size() >= 2) {
            int tmpHighestProduct = maxPositiveValues.get(0) *
                    maxNegativeValues.get(0) * maxNegativeValues.get(1);
            if (tmpHighestProduct > highestProduct) {
                highestProduct = tmpHighestProduct;
            }
         }

        // two possibilities to have min negative value
        // 1) min neg * second min neg * third min neg
        if (maxPositiveValues.size() == 0 && minNegativeValues.size() == 3) {
            highestProduct = minNegativeValues.get(0) *
                    minNegativeValues.get(1) * minNegativeValues.get(2);
        }

        // 2) min neg * min pos * second min pos
        if (minNegativeValues.size() >= 1 && minPositiveValues.size() >= 2) {
            int tmpHighestProduct = minNegativeValues.get(0) *
                    minPositiveValues.get(0) * minPositiveValues.get(1);
            if (tmpHighestProduct > highestProduct) {
                highestProduct =  tmpHighestProduct;
            }
        }

        // check with 0 value
        if (zeroExist && highestProduct < 0) {
            return 0;
        }
        return highestProduct;
    }
}
