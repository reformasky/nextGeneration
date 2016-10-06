package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 9/6/16.
 */
public class OddEvenList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next,
                cOdd = odd, cEven = even;
        ListNode curr = cEven.next;
        boolean isOdd = true;
        while(curr != null) {
            if (isOdd) {
                cOdd.next = curr;
                cOdd = curr;
            } else {
                cEven.next = curr;
                cEven = curr;
            }
            isOdd = !isOdd;
            curr = curr.next;
        }
        cEven.next = null;
        cOdd.next = even;
        return odd;
    }
}
