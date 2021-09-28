package com.leet_code.tree;

/**
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same structure and node values
 * of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree
 * and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubtreeOfAnotherTree {
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

    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root == null) return false;
            if(root.val == subRoot.val && isSameTree(root, subRoot)) return true;
            if(isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)) return true;
            return false;
        }

        private boolean isSameTree(TreeNode root, TreeNode subRoot) {
            if(root == null || subRoot == null) return root == null && subRoot == null;
            if(root.val == subRoot.val && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right)) return true;
            return false;
        }
    }
}
