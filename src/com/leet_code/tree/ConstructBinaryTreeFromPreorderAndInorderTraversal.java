package com.leet_code.tree;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder,
                0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder,
                          int InStart, int InEnd){
        if(preStart > preEnd){
            return null;
        }

        int index = 0;
        int value = preorder[preStart];
        TreeNode root = new TreeNode(value);
        for(int i = 0; i <= InEnd; i++){
            if(inorder[i] == value){
                index = i;
                break;
            }
        }

        int leftSize = index - InStart;
        root.left = build(preorder, preStart + 1,
                preStart + leftSize, inorder, InStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, InEnd);

        return root;
    }
}
