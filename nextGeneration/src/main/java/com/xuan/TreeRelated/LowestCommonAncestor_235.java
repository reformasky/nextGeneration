package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 8/10/16.
 */
public class LowestCommonAncestor_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        if (p == q) {
            return q;
        }
        if (p == null || q == null) {
            return p == null ? q : p;
        }
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val < q.val) {
            return root;
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
