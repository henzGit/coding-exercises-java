package com.leet_code.dynamic_programming;

/**
 * You are given an integer array nums.
 * You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int balance = nums[0];
        for(int i=1; i<nums.length; i++){
            if(balance <= 0)
                return false;
            else if(balance - 1 < nums[i])
                balance = nums[i];
            else
                balance--;
        }
        return true;

    }
}
