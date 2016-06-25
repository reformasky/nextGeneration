package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

import java.util.Stack;

/**
 * Created by xzhou2 on 6/25/16.
 */
public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode tmp = result.next;
        result.next = head;
        head.next = swapPairs(tmp);
        return result;
    }

    public ListNode swapPairs_nonRecursion(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        while(head != null && head.next != null) {
            ListNode tmp = head.next.next;
            curr.next = head.next;
            curr.next.next = head;
            curr = head;
            head.next = null;
            head = tmp;
        }
        if (head != null) {
            curr.next = head;
        }
        return pre.next;
    }
}
