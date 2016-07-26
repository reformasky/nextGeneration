package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/24/16.
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode oneStep = head, twoStep = head.next;
        while(twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }

        ListNode reverse = oneStep.next;
        oneStep.next = null;
        merge(head, reverse(reverse));
    }

    private ListNode reverse(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode curr = node.next, pre = node, next;
        while(curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        node.next = null;
        return pre;
    }

    private void merge(ListNode first, ListNode second) {
        ListNode curr = new ListNode(-1);
        while(second != null) {
            curr.next = first;
            first = first.next;
            curr = curr.next;
            curr.next = second;
            second = second.next;
            curr = curr.next;
        }
        if (first != null) {
            curr.next = first;
        }
    }
}
