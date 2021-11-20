package com.leet_code.tree;

/**
 * There is a binary tree rooted at 0 consisting of n nodes.
 * The nodes are labeled from 0 to n - 1. You are given a 0-indexed integer array
 * parents representing the tree, where parents[i] is the parent of node i.
 * Since node 0 is the root, parents[0] == -1.
 *
 * Each node has a score. To find the score of a node, consider if the node and
 * the edges connected to it were removed.
 * The tree would become one or more non-empty subtrees.
 * The size of a subtree is the number of the nodes in it.
 * The score of the node is the product of the sizes of all those subtrees.
 *
 * Return the number of nodes that have the highest score.
 * https://leetcode.com/problems/count-nodes-with-the-highest-score/
 */
public class CountNodesWithHighestScore {
    class TreeNode {
        TreeNode left, right;
        long score;
        int nodeCount;
    }

    public int countNodes(TreeNode node) {
        if(node == null) return 0;
        int count = 1 + countNodes(node.left) + countNodes(node.right);
        node.nodeCount = count;
        return count;
    }

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;

        TreeNode[] tree = new TreeNode[n];
        for(int i = 0; i< n; i++) {
            tree[i] = new TreeNode();
        }

        for(int i = 1; i < n; i++) {
            int parentId = parents[i];
            if(tree[parentId].left == null) {
                tree[parentId].left = tree[i];
            } else {
                tree[parentId].right = tree[i];
            }
        }

        countNodes(tree[0]);

        long maxScore = 0l;
        for(int i = 0; i < n; i++) {
            long product = 1l;

            if(tree[i].left != null) {
                product *= tree[i].left.nodeCount;
            }
            if(tree[i].right != null) {
                product *= tree[i].right.nodeCount;
            }
            if(parents[i] != -1) {
                product *= (n - tree[i].nodeCount);
            }

            tree[i].score = product;
            maxScore = Math.max(maxScore, product);
        }

        int out = 0;
        for(int i = 0; i < n; i++) {
            if(tree[i].score == maxScore) out++;
        }
        return out;
    }
}
