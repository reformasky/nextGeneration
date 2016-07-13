package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/10/16.
 */
public class RevertLinkedList_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if ( m == n) {
            return head;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre = result, next;
        int i = 0;
        ListNode curr = result;
        while(i++ <= n) {
            if (i == m) {
                pre = curr;
            }
            curr = curr.next;
        }
        next = curr;
        head = pre.next;
        curr = head;
        head = head.next;
        ListNode temp;
        while(head.next != next) {
            temp = head.next;
            head.next = curr;
            curr = head;
            head = temp;
        }
        head.next = curr;
        pre.next.next = next;
        pre.next = head;
        return result.next;
    }
}
