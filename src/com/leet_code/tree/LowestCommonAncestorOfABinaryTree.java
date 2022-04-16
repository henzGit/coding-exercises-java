package com.leet_code.tree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is
 * defined between two nodes p and q as the lowest node in T that has both p and q
 * as descendants (where we allow a node to be a descendant of itself).”
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfABinaryTree {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        if(p.val<root.val && q.val<root.val) return lowestCommonAncestor(root.left,p,q);
        if(p.val>root.val && q.val>root.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
