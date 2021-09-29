package com.leet_code.tree;
import java.util.*;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostOrderTraversal {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        dfs(root, out);
        return out;
    }

    private void dfs(TreeNode node, List<Integer> out) {
        if(node == null) return;
        if(node.left != null) dfs(node.left, out);
        if(node.right != null) dfs(node.right, out);
        out.add(node.val);
    }

}
