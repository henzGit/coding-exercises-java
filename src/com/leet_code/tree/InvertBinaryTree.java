package com.leet_code.tree;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
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

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = r;
        root.right = l;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
