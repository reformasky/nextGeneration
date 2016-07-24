package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 7/19/16.
 */
public class PathSum_129 {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int curr) {
        curr = 10 * curr + root.val;
        if (root.left == null && root.right == null) {
            result += curr;
            return;
        }
        if (root.left != null) {
            helper(root.left, curr);
        }
        if (root.right != null) {
            helper(root.right, curr);
        }
    }
}
