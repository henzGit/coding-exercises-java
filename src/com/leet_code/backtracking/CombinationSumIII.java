package com.leet_code.backtracking;
import java.util.*;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same
 * combination twice, and the combinations may be returned in any order.
 *
 *
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> out = new ArrayList<>();
        findSum(k, n, out, new ArrayList<Integer>(), 1);
        return out;
    }

    private void findSum(int k, int n, List<List<Integer>> out, List<Integer> cur, int num) {
        if(k == 0 && n == 0) {
            out.add(new ArrayList<>(cur));
            return;
        }
        if(n < 0 || k == 0) return;

        for(int i = num; i <= 9; i++ ) {
            if(i <= n) {
                cur.add(i);
                findSum(k-1, n-i, out, cur, i+1);
                cur.remove(cur.size()-1);
            }
        }

    }
}
