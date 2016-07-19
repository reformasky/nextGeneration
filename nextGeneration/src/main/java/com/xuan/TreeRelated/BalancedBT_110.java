package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 7/14/16.
 */
public class BalancedBT_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return height(root) >= 0;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = height(node.left);
        if (l < 0) {
            return -1;
        }
        int r = height(node.right);
        if (r < 0) {
            return -1;
        }

        if (Math.abs(l - r) > 1) {
            return -1;
        }

        return Math.max(l ,r) + 1;
    }
}
