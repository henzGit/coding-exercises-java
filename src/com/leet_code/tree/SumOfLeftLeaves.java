package com.leet_code.tree;

/**
 * Given the root of a binary tree, return the sum of all left leaves.
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {
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

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        TreeNode l = root.left;
        TreeNode r = root.right;
        int sumL = sumOfLeftLeaves(l);
        int sumR = sumOfLeftLeaves(r);

        int sum = 0;
        if(l != null) {
            if(l.left == null && l.right == null) sum = l.val;
        }

        return sumL + sumR + sum;
    }
}
