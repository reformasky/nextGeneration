package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 10/11/16.
 */
public class SumOfLeftNodes_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return left ? root.val : 0;
        }
        return helper(root.left, true) + helper(root.right, false);
    }
}
