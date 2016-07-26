package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/25/16.
 */
public class InsertSortLinkedList_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode pre = new ListNode(-1), curr;
        while(head != null) {
            ListNode tmp = head.next;
            curr = pre;
            while(curr.next != null && curr.next.val < head.val) {
                curr = curr.next;
            }
            head.next = curr.next;
            curr.next = head;
            head  = tmp;
        }
        return pre.next;
    }
}
