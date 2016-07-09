package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/8/16.
 */
public class RemoveDuplicateFromSortedList_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        boolean isDup = false;
        ListNode temp = head;
        head = head.next;
        while(head != null) {
            if (temp.val == head.val) {
                isDup = true;
            }
            else {
                if (!isDup) {
                    curr.next = temp;
                    curr = curr.next;
                }
                temp = head;
                isDup = false;
            }
            head = head.next;
        }
        if (!isDup) {
            curr.next = temp;
            curr = curr.next;
        }
        curr.next = null;
        return pre.next;
    }
}
