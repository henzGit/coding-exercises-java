package com.leet_code.array;

/**
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves
 * of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in tops are the same,
 * or all the values in bottoms are the same.
 *
 * If it cannot be done, return -1.
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class MinimumDominoRotainsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minSwap = Math.min(minSwaps(tops[0], tops, bottoms), minSwaps(bottoms[0], tops, bottoms));
        minSwap = Math.min(minSwap, minSwaps(tops[0], bottoms, tops));
        minSwap = Math.min(minSwap, minSwaps(bottoms[0], bottoms, tops));
        return minSwap == Integer.MAX_VALUE ? -1: minSwap;
    }

    private int minSwaps(int target, int[] A, int[] B) {
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != target && B[i] != target) return Integer.MAX_VALUE;
            if(target != A[i] && target == B[i]) count++;
        }
        return count;
    }}
