package com.leet_code.tree;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding
 * up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasRec(root, targetSum, 0);
    }

    private boolean hasRec(TreeNode node, int targetSum, int curSum) {
        if(node == null) return false;

        TreeNode left = node.left;
        TreeNode right = node.right;

        int nextSum = node.val + curSum;

        if(left == null && right == null && nextSum == targetSum ) {
            return true;
        }

        return hasRec(left, targetSum, nextSum) || hasRec(right, targetSum, nextSum);
    }
}
