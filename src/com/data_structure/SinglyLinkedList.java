package com.data_structure;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    /**
     * Pointer to first node of the list
     */
    private Node<E> head;

    /**
     * Pointer to last node of the list
     */
    private Node<E> tail;

    /**
     * Node containing item for the list
     * Since this is a singly linkedlist, there is only reference to the next node
     * @param <E>
     */
    static class Node<E> {
        E item;
        Node<E> next;

        Node(E item) {
            this.item = item;
            this.next = null;
        }
    }

    /**
     * Constructs an empty list.
     */
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Add an element to the head of the list
     * @param e element to be added to the beginning of the list
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (this.head != null) {
            Node<E> currHead = this.head;
            // point the next pointer of new node to current head
            newNode.next = currHead;
        }
        // make the new node as the current head
        this.head = newNode;
        // for first element addition, head pointer equals to tail pointer
        if (this.tail == null) {
            this.tail = newNode;
        }
    }

    /**
     * Add an element to the end of the list
     * @param e element to be added to the end of the list
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (this.tail != null) {
            Node<E> currTail = this.tail;
            // point the next pointer of current tail to newly created node
            currTail.next = newNode;
        }
        // make the new node as the current tail
        this.tail= newNode;
        // for first element addition, head pointer equals to tail pointer
        if (this.head == null) {
            this.head = newNode;
        }
    }

    /**
     * Add an element to the end of the list
     * @param e element to be added to the end of the list
     */
    public void add(E e) {
        addLast(e);
    }

    /**
     * Print all elements in a list
     */
    public void printList() {
        Node<E> currPointer = head;
        while(currPointer != null) {
            System.out.print(currPointer.item.toString());
            currPointer = currPointer.next;
        }
        System.out.println();
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getHead() {
        final Node<E> h = head;
        if (h == null)
            throw new NoSuchElementException();
        return h.item;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getTail() {
        final Node<E> t = tail;
        if (t == null)
            throw new NoSuchElementException();
        return t.item;
    }

    /**
     * Reverse list
     */
    public void reverseList() {
        Node<E> prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // swap tail and head pointer
        Node<E> tmpHead = head;
        Node<E> tmpTail = tail;
        head = tmpTail;
        tail = tmpHead;
    }
}
