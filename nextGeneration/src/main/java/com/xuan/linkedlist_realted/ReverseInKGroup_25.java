package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 6/25/16.
 */
public class ReverseInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
            ListNode curr = head, result = head, next, pre;
        for(int i = 0; i < k - 1; i++) {
            result = result.next;
            if (result == null) {
                return head;
            }
        }
        pre = reverseKGroup(result.next, k);
        result.next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return result;
    }
}
