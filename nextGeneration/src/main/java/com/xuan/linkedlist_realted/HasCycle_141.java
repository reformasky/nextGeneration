package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/23/16.
 */
public class HasCycle_141 {
    public boolean hasCycle(ListNode head) {
        ListNode oneStep = head, twoStep = head;
        while(twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) {
                return true;
            }
        }
        return false;
    }
}
