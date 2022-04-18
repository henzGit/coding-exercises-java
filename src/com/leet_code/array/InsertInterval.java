package com.leet_code.array;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals
 * where intervals[i] = [starti, endi] represent the start and the end of
 * the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents
 * the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending
 * order by starti and intervals still does not have any overlapping intervals
 * (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        res.add(newInterval);

        for(int[] interval: intervals) {
            int[] tmp = res.remove(res.size()-1);
            int start = tmp[0];
            int end = tmp[1];

            if(start > interval[1] ) {
                res.add(interval);
                res.add(tmp);
            } else if(start == interval[1]) {
                int[] merge = new int[] {interval[0], end};
                res.add(merge);
            } else if(start < interval[1]) {
                if(end < interval[0]) {
                    res.add(tmp);
                    res.add(interval);
                } else {
                    int[] merge = new int[2];
                    merge[0] = Math.min(start, interval[0]);
                    merge[1] = Math.max(end, interval[1]);
                    res.add(merge);
                }
            }
        }

        int n = res.size();
        int[][] out = new int[n][2];

        for(int i=0; i<n; i++) {
            out[i] = res.get(i);
        }

        return out;
    }
}
