package com.leet_code.backtracking;
import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        backtrack(candidates, target, out, 0, new ArrayList<Integer>());
        return out;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> out,
                           int index, List<Integer> current) {
        if(target == 0) out.add(new ArrayList<Integer>(current));
        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] <= target) {
                current.add(candidates[i]);
                backtrack(candidates, target-candidates[i], out, i, current);
                current.remove(current.size()-1);
            }
        }
    }
}
