package com.leet_code.data_structure;


/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
            if (slow.next != null) slow = slow.next;
            if (fast.next != null) fast = fast.next;
            fast = fast.next;
        }
        ListNode prev = null;
        while(slow != null) {
            ListNode tmpNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmpNext;
        }

        ListNode n1 = head;
        ListNode n2 = prev;
        while(n1 != null && n2!= null) {
            if(n1.val != n2.val) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
}
