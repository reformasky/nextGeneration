package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/9/16.
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode preSmaller = new ListNode(-1),
                preOther = new ListNode(-1);
        ListNode currSmaller = preSmaller, currOther = preOther;
        while(head != null) {
            if (head.val < x) {
                currSmaller.next = head;
                currSmaller = currSmaller.next;
            }
            else {
                currOther.next = head;
                currOther = currOther.next;
            }
            head = head.next;
        }

        currSmaller.next = preOther.next;
        currOther.next = null;
        return preSmaller.next;
    }
}
