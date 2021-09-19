package com.leet_code.dynamic_programming;

public class PartitionEqualSubsetSum {
    Boolean[] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if(sum % 2 != 0) return false;
        int target = sum/2;
        memo = new Boolean[target+1];
        boolean res = helper(nums, 0, target);
        return res;
    }

    private boolean helper(int[] nums, int idx, int target) {
        if(target == 0) return true;
        if(memo[target] != null) return memo[target];

        for(int i = idx; i <nums.length; i++) {
            if(nums[i] > target) continue;
            boolean res = helper(nums, i+1, target-nums[i]);
            memo[target-nums[i]] = res;
            if(res) return true;
        }
        return false;
    }
}
