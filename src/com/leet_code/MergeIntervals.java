package com.leet_code;
import java.util.*;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping
 * intervals that cover all the intervals in the input.
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a,b) -> b[1] - a[1]
        );

        for(int[] interval: intervals) {
            if(maxHeap.size() == 0) maxHeap.offer(interval);
            else {
                int[] top = maxHeap.poll();

                if(interval[1] == top[0]) {
                    int[] newInterval = {interval[0], top[1]};
                    maxHeap.offer(newInterval);
                } else if(top[1] == interval[0]) {
                    int[] newInterval = {top[0], interval[1]};
                    maxHeap.offer(newInterval);
                } else if(interval[1] < top[0] || top[1] < interval[0]) {
                    maxHeap.offer(top);
                    maxHeap.offer(interval);
                } else {
                    int start = interval[0] < top[0] ? interval[0] : top[0];
                    int end = interval[1] > top[1] ? interval[1] : top[1];
                    int[] newInterval = {start, end};
                    maxHeap.offer(newInterval);
                }
            }
        }

        int n = maxHeap.size();

        int[][] out = new int[n][];
        for(int i = 0; i < n; i++) {
            out[i] = maxHeap.poll();
        }

        return out;
    }
}
