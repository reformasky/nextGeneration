package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 8/10/16.
 */
public class LowestCommonAncestor_236 {

    public TreeNode lowestCommonAncestor_cleaner(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return (TreeNode)(helper(root, p, q)[0]);
    }

    private Object[] helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new Object[]{null, 0};
        }
        Integer count = 0;
        if (node == p) {
            count++;
        }
        if (node == q) {
            count++;
        }
        if (count >= 2) {
            return new Object[]{node, count};
        }
        Object[] left = helper(node.left, p, q);
        if (left[0] != null) {
            return left;
        }
        count+= (Integer)(left[1]);
        if (count >= 2) {
            return new Object[]{node, count};
        }
        Object[] right = helper(node.right, p, q);
        if (right[0] != null) {
            return right;
        }
        count+=(Integer)(right[1]);
        if (count >= 2) {
            return new Object[]{node, count};
        }
        return new Object[]{null, count};
    }
}
