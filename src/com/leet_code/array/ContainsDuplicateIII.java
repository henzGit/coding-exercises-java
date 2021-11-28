package com.leet_code.array;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an integer array nums and two integers k and t, return true if
 * there are two distinct indices i and j in the array such that
 * abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        SortedSet<Long> set = new TreeSet<Long>();
        int toRemove = 0;
        for(int num : nums) {
            Set<Long> subset = set.subSet((long)num - t, (long)num + t + 1);
            if(!subset.isEmpty()) {
                return true;
            }
            set.add((long)num);
            if(set.size() > k) {
                long el = (long)nums[toRemove++];
                set.remove(el);
            }
        }
        return false;
    }
}
