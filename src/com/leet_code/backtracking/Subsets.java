package com.leet_code.backtracking;
import java.util.*;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        recursiveSubsets(out, nums, new ArrayList<Integer>() , 0);
        return out;
    }

    private void recursiveSubsets(List<List<Integer>> out, int[] nums, List<Integer> current, int index) {
        out.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            recursiveSubsets(out, nums, current, i+1);
            current.remove(current.size()-1);
        }
    }
}
