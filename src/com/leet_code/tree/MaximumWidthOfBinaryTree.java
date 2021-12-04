package com.leet_code.tree;

import java.util.LinkedList;

/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes
 * (the leftmost and rightmost non-null nodes), where the null nodes between
 * the end-nodes are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class MaximumWidthOfBinaryTree {
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

    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> nbr = new LinkedList<>();
        queue.add(root);
        nbr.add(0);
        int maxWidth = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();

            if(nbr.size() >= 2) {
                int left = nbr.getFirst();
                int right = nbr.getLast();
                int width = right - left + 1 ;
                maxWidth = Math.max(maxWidth, width);
            }

            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.removeFirst();
                int curValue = nbr.removeFirst();
                if(cur.left != null) {
                    queue.add(cur.left);
                    nbr.add(curValue * 2);

                };
                if(cur.right != null) {
                    queue.add(cur.right);
                    nbr.add((curValue * 2) + 1);
                }
            }

        }

        return maxWidth;
    }
}
