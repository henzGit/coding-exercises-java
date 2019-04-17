package com.tree_traversal;

public class BinaryTree<E>
{
    /**
     * Node containing an element
     */
    public static class Node<E>
    {
        // element in the node
        E item;
        // pointer to left and right
        Node<E> left, right;

        public Node(E item)
        {
            this.item = item;
            this.left = this.right = null;
        }

        public void setLeft(E e) {
            this.left = new Node<>(e);
        }

        public void setRight(E e) {
            this.right = new Node<>(e);
        }

        public Node<E> getLeft() {
            return this.left;
        }

        public Node<E> getRight() {
            return this.right;
        }
    }

    // Root of Binary Tree
    private Node<E> root;

    public BinaryTree()
    {
        this.root = null;
    }

    public void setRoot(E e) {
        this.root = new Node<>(e);
    }

    public Node<E> getRoot() {
        return this.root;
    }

    /* Given a binary tree, print its nodes according to the
        "bottom-up" postorder traversal. */
    void printPostorder(Node node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.item + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.item + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.item + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    public void printPostorder() { printPostorder(root); }
    public void printInorder()   { printInorder(root); }
    public void printPreorder()  { printPreorder(root); }

}

