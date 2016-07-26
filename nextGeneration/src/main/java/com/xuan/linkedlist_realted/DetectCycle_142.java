package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/24/16.
 */
public class DetectCycle_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode oneStep = head, twoStep = head;
        while(twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) {
                break;
            }
        }

        if (twoStep == null|| twoStep.next == null) {
            return null;
        }
        oneStep = head;
        while(oneStep != twoStep) {
            oneStep = oneStep.next;
            twoStep = twoStep.next;
        }
        return oneStep;
    }
}
