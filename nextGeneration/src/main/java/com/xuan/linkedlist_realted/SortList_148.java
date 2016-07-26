package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 7/25/16.
 */
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head, second;
        ListNode oneStep = head, twoStep = head.next;
        while(twoStep != null && twoStep.next != null) {
            twoStep = twoStep.next.next;
            oneStep = oneStep.next;
        }
        second = oneStep.next;
        oneStep.next = null;
        first = sortList(first);
        second = sortList(second);
        return merge(first, second);
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode pre = new ListNode(-1), curr = pre, tmp;
        while(first != null && second != null) {
            if (first.val > second.val) {
                tmp = second;
                second = second.next;
            } else {
                tmp = first;
                first = first.next;
            }
            curr.next = tmp;
            curr = curr.next;
        }

        tmp = first == null ? second : first;
        while(tmp != null) {
            curr.next = tmp;
            tmp = tmp.next;
            curr = curr.next;
        }
        return pre.next;
    }
}
