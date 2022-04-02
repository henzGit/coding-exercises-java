package com.leet_code.greedy;

import java.util.Arrays;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest
 * of the intervals non-overlapping.
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);

        int end = Integer.MIN_VALUE, cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] >= end)
                end = arr[i][1];
            else
                cnt++;
        }
        return cnt;


    }
}
}
