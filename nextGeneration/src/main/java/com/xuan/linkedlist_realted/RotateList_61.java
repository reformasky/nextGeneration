package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/4/16.
 */
public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode fast = head, slow = head;
        while(fast != null) {
            fast = fast.next;
            length++;
        }
        k %= length;
        if (k ==0) {
            return head;
        }
        fast = head;
        while(k >0) {
            k--;
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
