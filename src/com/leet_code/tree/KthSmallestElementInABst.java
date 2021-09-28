package com.leet_code.tree;
import java.util.*;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest
 * value (1-indexed) of all the values of the nodes in the tree.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInABst {
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

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k-1);
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
