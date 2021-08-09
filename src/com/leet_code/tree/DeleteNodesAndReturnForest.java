package com.leet_code.tree;
import java.util.*;
/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest
 * (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
public class DeleteNodesAndReturnForest {
    static class TreeNode {
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();

        Set<Integer> toDelete = new HashSet<>();
        for(int i = 0; i < to_delete.length; i++) {
            toDelete.add(to_delete[i]);
        }

        delRec(root, toDelete, res);
        if(!toDelete.contains(root.val)) res.add(root);

        return res;
    }


    private TreeNode delRec(TreeNode node, Set<Integer> toDelete, List<TreeNode> res) {
        if(node == null) return null;

        node.left = delRec(node.left, toDelete, res);
        node.right = delRec(node.right, toDelete, res);

        if(toDelete.contains(node.val)) {
            if(node.left != null) res.add(node.left);
            if(node.right != null) res.add(node.right);
            return null;
        }
        return node;

    }
}
