package com.xuan.TreeRelated;

import com.xuan.util.TreeLinkNode;

/**
 * Created by xzhou2 on 7/18/16.
 */
public class PopulateNextRight_117 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode pre = root,
                curr = null, begin = null;
        while(pre != null) {
            begin = new TreeLinkNode(-1);
            curr = begin;
            while(pre != null) {
                if (pre.left != null) {
                    curr.next = pre.left;
                    curr = curr.next;
                }
                if (pre.right != null) {
                    curr.next = pre.right;
                    curr = curr.next;
                }
                pre = pre.next;
            }
            pre = begin.next;
        }
    }
}
