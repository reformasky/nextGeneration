package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 7/12/16.
 */
public class RecoverBST_99 {
    TreeNode first = null, second = null, pre = null, curr = null;
    public void recoverTree(TreeNode root) {
        dfs_Morris(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dfs_Morris(TreeNode root) {
        while(root != null) {
            curr = null;
            if (root.left == null) {
                curr = root;
                root = root.right;
            }
            else {
                TreeNode p = root.left;
                while(p.right != null && p.right != root) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = root;
                    root = root.left;
                }
                else {
                    p.right = null;
                    curr = root;
                    root = root.right;
                }
            }
            if (curr != null) {
                if (pre != null && pre.val > curr.val) {
                    second = curr;
                    if (first == null) {
                        first = pre;
                    }
                }
                pre = curr;
            }
        }
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
