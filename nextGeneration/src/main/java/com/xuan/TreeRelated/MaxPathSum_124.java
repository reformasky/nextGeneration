package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 7/18/16.
 */
public class MaxPathSum_124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        int result = root.val,l = Integer.MIN_VALUE, r = Integer.MIN_VALUE;
        if (root.left != null) {
            l = helper(root.left);
        }
        if (root.right != null) {
            r = helper(root.right);
        }
        int temp = root.val;
        if (l > 0) {
            temp += l;
            result = temp;
        }
        if (r > 0) {
            temp += r;
            result = Math.max(result, root.val + r);
        }
        max = Math.max(temp, max);
        return result;
    }
}
