package com.leet_code.tree;
import java.util.*;
/**
 * Given the root of a binary tree and an integer targetSum,
 * return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<Integer>());
        return count;
    }

    private void dfs(TreeNode root, int targetSum, ArrayList<Integer> curList) {
        if(root == null) return;
        if(root.val == targetSum) count++;

        for(int i = 0; i < curList.size(); i++) {
            int newSum = curList.get(i) + root.val;
            if( newSum == targetSum) count++;
            curList.set(i, newSum);
        }
        curList.add(root.val);
        dfs(root.left, targetSum, new ArrayList<>(curList));
        dfs(root.right, targetSum, new ArrayList<>(curList));
    }
}
