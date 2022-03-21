package com.leet_code.linked_list;

/**
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 *
 *
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 *
 * Note that the linked lists must retain their original structure after the function returns.
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int nA = getLenList(headA);
        int nB = getLenList(headB);

        int forward = 0;
        if(nA > nB) {
            forward = nA - nB;
            while(forward > 0) {
                headA = headA.next;
                forward--;
            }
        } else {
            forward = nB - nA;
            while(forward > 0) {
                headB = headB.next;
                forward--;
            }
        }

        while(headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getLenList(ListNode l) {
        int count = 0;
        while(l != null) {
            count++;
            l = l.next;
        }

        return count;
    }
}
