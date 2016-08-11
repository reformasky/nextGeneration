package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

/**
 * Created by xzhou2 on 8/10/16.
 */
public class DeleteNode_237 {
    public void deleteNode(ListNode node) {
        ListNode curr = node, pre = curr;
        while(curr.next != null) {
            pre = curr;
            curr.val = curr.next.val;
            curr = curr.next;
        }
        pre.next = null;
    }
}
