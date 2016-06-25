package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 6/24/16.
 */
public class RemoveNthFromTail_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode tail = head, curr = head;
        for(int i = 0; i <= n; i++) {
            if (tail == null) {
                return head.next;
            }
            tail = tail.next;
        }
        while(tail != null) {
            curr = curr.next;
            tail = tail.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
