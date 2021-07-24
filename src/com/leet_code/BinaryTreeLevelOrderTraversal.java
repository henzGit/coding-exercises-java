package com.leet_code;
import java.util.*;
/**
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.size() > 0) {
            List<Integer> l = new LinkedList<>();
            int size = queue.size();
            for(int i=0; i < size; i++) {
                TreeNode cur = queue.poll();
                l.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add(l);
        }
        return res;
    }
}
