package com.xuan.TreeRelated;

import com.xuan.other.Trie;
import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 8/8/16.
 */
public class KthSmallestInBST_230 {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root, pre;
        while(curr != null) {
            if (curr.left == null) {
                if (--k == 0) {
                    return curr.val;
                }
                curr = curr.right;
            } else {
                pre = curr.left;
                while(pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    if (--k == 0) {
                        return curr.val;
                    }
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }

    public int kthSmallest_count(TreeNode root, int k) {
        int count = count(root.left);
        if (count > k) {
            return kthSmallest_count(root.left, k);
        } else if (count < k) {
            return kthSmallest_count(root.right, k - 1 - count);
        }
        return root.val;
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}