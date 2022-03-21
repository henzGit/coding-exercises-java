package com.leet_code.linked_list;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        ListNode prev = null;
        while(p.next != null) {
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;

        }
        p.next = prev;
        return p;

    }
}
