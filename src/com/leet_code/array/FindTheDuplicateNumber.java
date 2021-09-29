package com.leet_code.array;

/**
 * Given an array of integers nums containing n + 1 integers where each
 * integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        slow = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[fast];
            if(slow == fast) break;
        }

        return slow;
    }
}
