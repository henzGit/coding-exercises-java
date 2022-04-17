package com.leet_code.array;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int low = 0;
        int n = nums.length;
        int high = n-1;
        int sum;
        Set<List<Integer>> temp = new HashSet<List<Integer>>();

        List<Integer> out = null;
        for(int i = 0; i < n-2; i++) {
            low = i+1;
            high = n-1;
            while(low < high) {
                sum = nums[i] + nums[low] + nums[high];
                if(sum == 0){
                    out = new ArrayList<Integer>();
                    out.add(nums[i]);
                    out.add(nums[low]);
                    out.add(nums[high]);

                    temp.add(out);
                    low++;
                    high--;

                } else if(sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        List<List<Integer>> aList = new ArrayList<List<Integer>>(temp);
        return aList;
    }
}
