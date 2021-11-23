package com.leet_code.backtracking;

import java.util.List;

/**
 * In LeetCode Store, there are n items to sell. Each item has a price.
 * However, there are some special offers, and a special offer consists of one or
 * more different kinds of items with a sale price.
 *
 * You are given an integer array price where price[i] is the price of the ith item,
 * and an integer array needs where needs[i] is the number of pieces of the ith item you want to buy.
 *
 * You are also given an array special where special[i] is of
 * size n + 1 where special[i][j] is the number of pieces of the jth item
 * in the ith offer and special[i][n] (i.e., the last integer in the array) is the price of the ith offer.
 *
 * Return the lowest price you have to pay for exactly certain items as given,
 * where you could make optimal use of the special offers.
 * You are not allowed to buy more items than you want, even if that would lower the overall price.
 * You could use any of the special offers as many times as you want.
 * https://leetcode.com/problems/shopping-offers/
 */
public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int pRec[] = new int[1];
        pRec[0] = Integer.MAX_VALUE;
        backtrack(pRec, needs, special, price, 0);

        return pRec[0];
    }

    private void backtrack(int[] pRec, List<Integer> needs, List<List<Integer>> offers, List<Integer> price, int tmpPrice) {
        int n = needs.size();
        for(int i = 0; i < offers.size(); i++) {
            List<Integer> offer = offers.get(i);
            if(!canTakeOffer(offer, needs)) continue;
            for(int j = 0; j < n; j++) {
                int newValue = needs.get(j) - offer.get(j);
                needs.set(j, newValue);
            }
            tmpPrice += offer.get(offer.size()-1);
            backtrack(pRec, needs, offers, price, tmpPrice);
            for(int j = 0; j < n; j++) {
                int oriValue = needs.get(j) + offer.get(j);
                needs.set(j, oriValue);
            }
            tmpPrice -= offer.get(offer.size()-1);
        }
        for(int i = 0; i < n; i++) {
            if(needs.get(i) > 0) {
                tmpPrice += needs.get(i) * price.get(i);
            }
        }
        pRec[0] = Math.min(pRec[0], tmpPrice);

    }

    private boolean canTakeOffer(List<Integer> offer, List<Integer> needs) {
        for(int i = 0; i < needs.size(); i++) {
            if(needs.get(i) < offer.get(i)) return false;
        }
        return true;
    }

}
