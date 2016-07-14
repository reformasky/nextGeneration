package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 7/13/16.
 */
public class MaxDepthOfBT_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
