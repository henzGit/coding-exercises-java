package com.leet_code.linked_list;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, MergeTwoSortedLists.ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode p = head;
        ListNode p2 = head;
        int len = 0;
        while(p2 != null) {
            p2 = p2.next;
            len++;
        }
        if(n == len) {
            return head.next;
        }
        
        int i = len - n - 1;
        while( i > 0 ) {
            p = p.next;
            i--;
        }
        ListNode tmp = p.next.next;
        p.next = tmp;
        return head;



    }
}
