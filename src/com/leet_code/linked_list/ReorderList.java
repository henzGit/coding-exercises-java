package com.leet_code.linked_list;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode second = reverse(mid);

        while(head != second) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = second.next;
            head.next = second;

            if(tmp1 == second) break;
            else second.next = tmp1;

            head = tmp1;
            second = tmp2;
        }
    }

    public ListNode reverse(ListNode tmp) {
        ListNode prev = null;
        while(tmp != null) {
            ListNode next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;
        }
        return prev;
    }

    public ListNode findMid(ListNode tmp) {
        ListNode slow = tmp;
        ListNode fast = tmp;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast = fast.next;
        }
        return slow;
    }
}
