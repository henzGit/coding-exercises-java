package com.tree_traversal;

import com.data_structure.BinaryTree.Node;

public class TreeTraversal {
    /**
     * Try to get max element in a given level
     * @param node root node of the tree
     * @param level distance from the root node
     * @return max element if the node value is integer
     */
    public static Object getMaxElementInLevel(Node node, int level) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (!(node.getItem() instanceof Integer))
            throw new UnsupportedOperationException();
        if (level == 0) {
            return node.getItem();
        }

        return Math.max(
                (Integer) getMaxElementInLevel(node.getLeft(), level-1),
                (Integer) getMaxElementInLevel(node.getRight(), level-1)
        );
    }
}
