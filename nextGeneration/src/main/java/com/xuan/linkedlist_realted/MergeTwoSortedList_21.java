package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 6/24/16.
 */
public class MergeTwoSortedList_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        ListNode tmp = l1 == null ? l2 : l1;
        while(tmp != null) {
            curr.next = tmp;
            tmp = tmp.next;
            curr = curr.next;
        }
        return pre.next;
    }
}
