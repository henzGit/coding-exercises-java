package com.leet_code;
import java.util.*;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int res = nums[0];
        if (nums.length == 1) return res;

        Queue<Integer> minHeap = new PriorityQueue();
        for(int i=0; i<k; i++) minHeap.add(nums[i]);

        for(int j=k; j<nums.length; j++) {
            if(minHeap.peek()<nums[j]) {
                minHeap.remove();
                minHeap.add(nums[j]);
            }
        }
        return minHeap.peek();
    }
}
