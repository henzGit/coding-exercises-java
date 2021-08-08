package com.leet_code.greedy;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit
 * the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules
 * that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit.
 * There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree
 * (including the start tree) while moving to the right. The picked fruits must fit in
 * one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        if (fruits.length <=2) return fruits.length;

        int maxSum = 0;
        int k1 = 0;
        int k2 = -1;
        int type1 = fruits[0];
        int type2 = -1;
        int basket1 = 1, basket2 = 0;

        for(int i=1; i < fruits.length; i++) {
            if (fruits[i] == type1) {
                basket1++;
                k1 = i;
            }
            else if (fruits[i] != type1 && basket2 == 0) {
                basket2 = 1;
                type2 = fruits[i];
                k2 = i;
            }
            else if (fruits[i] == type2 && basket2 > 0) {
                basket2++;
                k2 = i;
            }
            else if (fruits[i] != type1 && fruits[i] != type2) {
                maxSum = Math.max(maxSum, basket1+basket2);
                int newK1;

                if(k1 > k2) {
                    newK1 = k2+1;
                } else {
                    type1 = type2;
                    newK1 = k1+1;
                    k1 = k2;
                }
                basket1 = i - newK1;
                basket2 = 1;
                type2 = fruits[i];
                k2 = i;
            }
        }
        return Math.max(maxSum, basket1+basket2);
    }
}
