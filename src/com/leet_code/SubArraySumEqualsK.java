package com.leet_code;
import java.util.*;

/**
 * Given an array of integers nums and an integer k,
 * return the total number of continuous subarrays whose sum equals to k.
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sumFreq = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (k == sum) count++;
            if(sumFreq.containsKey(sum-k)) count +=sumFreq.get(sum-k);
            if(sumFreq.containsKey(sum)) sumFreq.put(sum, sumFreq.get(sum)+1);
            else sumFreq.put(sum, 1);
        }
        return count;

    }
}
