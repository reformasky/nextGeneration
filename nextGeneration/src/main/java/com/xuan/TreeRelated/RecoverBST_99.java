package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 7/12/16.
 */
public class RecoverBST_99 {
    TreeNode first = null, second = null, pre = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        if(first != null && pre.val > root.val) {
            second = root;
            return;
        }
        if (pre != null && pre.val > root.val && first == null) {
            second = root;
            first = pre;
        }

        pre = root;
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
