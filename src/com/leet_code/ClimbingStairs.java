package com.leet_code;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int[] tab = new int[n+1];
        tab[0] = 1;
        tab[1] = 1;
        for(int i=2; i<=n; i++) {
            tab[i] = tab[i-1] + tab[i-2];
        }
        return tab[n];

    }
}
