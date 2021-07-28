package com.leet_code;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of
 * the two subtrees of every node never differs by more than one.
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBST {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            int n = nums.length;
            if(n == 1) {
                return  new TreeNode(nums[0]);
            }
            return createBST(nums, 0, nums.length-1);
        }

        private TreeNode createBST(int[] nums, int left, int right) {
            if(left > right) return null;

            int mid = left + (right-left)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = createBST(nums, left, mid-1);
            root.right = createBST(nums, mid+1, right);

            return root;
        }
    }
}
