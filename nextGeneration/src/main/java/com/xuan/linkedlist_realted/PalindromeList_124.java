package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 8/10/16.
 */
public class PalindromeList_124 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode pre = head, tail = head.next;
        while(tail != null && tail.next != null) {
            tail = tail.next.next;
            pre = pre.next;
        }

        ListNode second = reverse(pre.next);
        ListNode head1 = head, head2 = second;
        boolean result = true;
        while(head2 != null) {
            if (head1.val != head2.val) {
                result = false;
                break;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        second = reverse(second);
        pre.next = second;
        return result;
    }

    private ListNode reverse(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode pre = null, curr = node, tmp;
        while(curr != null) {
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }
}
