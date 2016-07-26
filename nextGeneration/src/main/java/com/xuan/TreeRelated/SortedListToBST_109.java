package com.xuan.TreeRelated;

import com.xuan.util.ListNode;
import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 7/14/16.
 */
public class SortedListToBST_109 {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        node = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return helper(0, count - 1);
    }

    private TreeNode helper(int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low)/ 2;
        TreeNode left = helper(low, mid - 1);
        TreeNode result = new TreeNode(node.val);
        node = node.next;
        result.left = left;
        result.right = helper(mid + 1, high);
        return result;

    }
}
