package com.leet_code.data_structure;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be
 * reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer
 * is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
     class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return false;
        ListNode runner = head.next;
        while(head != null && runner != null) {
            head = head.next;
            if (head == null) return false;
            runner = runner.next;
            if(runner == null) return false;
            runner = runner.next;
            if(head == runner) return true;

        }
        return false;
    }
}
