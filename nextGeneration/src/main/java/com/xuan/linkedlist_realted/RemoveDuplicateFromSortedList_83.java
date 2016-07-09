package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/8/16.
 */
public class RemoveDuplicateFromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(head.val == -1 ? -2 : -1);
        ListNode curr = pre;
        while(head != null) {
            if (head.val != curr.val) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        curr.next = null;
        return pre.next;
    }
}
