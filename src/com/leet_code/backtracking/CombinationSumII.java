package com.leet_code.backtracking;
import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(candidates);
        findSums(out, candidates, target, new ArrayList<Integer>(), 0);
        return out;
    }

    private void findSums(List<List<Integer>> out, int[] candidates, int target,
                          List<Integer> cur, int index) {
        if(target < 0) return;
        if(target == 0) {
            out.add(new ArrayList<>(cur));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(i == index || candidates[i] != candidates[i-1]) {
                cur.add(candidates[i]);
                findSums(out, candidates, target-candidates[i], cur, i+1);
                cur.remove(cur.size()-1);

            }
        }

    }
