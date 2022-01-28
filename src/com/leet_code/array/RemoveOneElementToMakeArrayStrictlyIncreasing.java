package com.leet_code.array;

/**
 * https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
 * Given a 0-indexed integer array nums, return true if it can be made strictly increasing
 * after removing exactly one element, or false otherwise. If the array is already strictly
 * increasing, return true.
 *
 * The array nums is strictly increasing if nums[i - 1] < nums[i] for each index (1 <= i < nums.length).
 */
public class RemoveOneElementToMakeArrayStrictlyIncreasing {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length-1; i++)
        {
            if(nums[i] >= nums[i+1])
            {
                count++;
                if(count == 2) return false;
                if(i > 0 && nums[i-1] >= nums[i+1])
                {
                    nums[i+1] = nums[i];
                }
            }
        }
        return true;
    }
}
