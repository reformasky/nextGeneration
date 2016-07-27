package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/26/16.
 */
public class LinkedListIntersection_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tail = headA;
        while(tail.next != null) {
            tail = tail.next;
        }
        tail.next = headB;
        ListNode oneStep = headA, twoStep = headA;
        while(twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) {
                break;
            }
        }
        if (twoStep == null || twoStep.next == null) {
            tail.next = null;
            return null;
        }
        oneStep = headA;
        while(oneStep != twoStep) {
            oneStep = oneStep.next;
            twoStep = twoStep.next;
        }

        tail.next = null;
        return oneStep;
    }
}
