package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/31/16.
 */
public class RemoveListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(-1), curr = pre;
        pre.next = head;
        while(curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return pre.next;
    }
}
