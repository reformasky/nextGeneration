package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 8/1/16.
 */
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head.next, pre = head, tmp;
        head.next = null;
        while(curr != null) {
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}
