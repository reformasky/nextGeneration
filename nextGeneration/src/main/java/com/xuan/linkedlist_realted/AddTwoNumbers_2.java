package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 6/16/16.
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        int carryOver = 0;
        ListNode currNode = pre;
        while(l1 != null && l2 != null) {
            int curr = carryOver + l1.val + l2.val;
            ListNode tmp = new ListNode(curr % 10);
            currNode.next = tmp;
            currNode = currNode.next;
            carryOver = curr / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l = l1 == null ? l2 : l1;
        while(l != null) {
            int curr = carryOver + l.val;
            ListNode tmp = new ListNode(curr % 10);
            currNode.next = tmp;
            currNode = currNode.next;
            carryOver = curr / 10;
            l = l.next;
        }
        if(carryOver != 0) {
            ListNode tmp = new ListNode(carryOver % 10);
            currNode.next = tmp;
        }
        return pre.next;
    }
}
