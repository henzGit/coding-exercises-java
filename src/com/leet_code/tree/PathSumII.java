package com.leet_code.tree;
import java.util.*;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values
 * in the path equals targetSum. Each path should be returned as a
 * list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at
 * any leaf node. A leaf is a node with no children.
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, targetSum, paths, new ArrayList(), 0);
        return paths;
    }

    private void findPaths(TreeNode root, int targetSum, List<List<Integer>> paths,
                           List<Integer> path, int curSum) {
        if(root == null) return;

        List<Integer> curPath = new ArrayList<>(path);
        curPath.add(root.val);
        if(root.left == null && root.right == null) {
            if(curSum + root.val == targetSum) {
                paths.add(curPath);
            }
        }
        if(root.left != null) {
            findPaths(root.left, targetSum, paths, curPath, curSum + root.val);
        }
        if(root.right != null) {
            findPaths(root.right, targetSum, paths, curPath, curSum +  root.val);

        }
    }
}
