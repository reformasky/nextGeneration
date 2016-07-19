package com.xuan.TreeRelated;

import com.xuan.util.TreeLinkNode;

/**
 * Created by xzhou2 on 7/15/16.
 */
public class ConnectChildren_116 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode curr = root, next = null;
        while(curr != null) {
            if (next == null) {
                next = curr.left;
            }
            if(curr.left != null) {
                while(curr.next != null) {
                    curr.left.next = curr.right;
                    curr.right.next = curr.next.left;
                    curr = curr.next;
                }
                curr.left.next = curr.right;

            }
            else {
                break;
            }
            curr = next;
            next = null;
        }
    }
}
