package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 6/22/16.
 */
public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        for(int i = 1; i < lists.length; i *= 2) {
            for(int j = 0; j < lists.length - i; j += 2 * i) {
                merge(lists, j, j + i);
            }
        }
        return lists[0];
    }

    private void merge(ListNode[] lists, int i, int j) {
        if (lists[i] == null) {
            lists[i] = lists[j];
            return;
        }
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        ListNode left = lists[i], right = lists[j];
        while(left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            }
            else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        left = left == null ? right : left;
        while(left != null) {
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }
        curr.next = null;
        lists[i] = head.next;
    }
}
