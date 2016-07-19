package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.Stack;

/**
 * Created by xzhou2 on 7/15/16.
 */
public class FlattenBT_114 {
    public void flatten_Morris(TreeNode root) {
        if (root == null) {
            return;
        }
        while(root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            }
            TreeNode left = root.left;
            while(left.right != null) {
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null ) {
            if (curr.left != null&& curr.right != null) {
                stack.push(curr.right);
                curr.right = curr.left;
            }
            else if (curr.left != null) {
                curr.right = curr.left;
            }
            else if (curr.right != null) {

            }
            else if (!stack.isEmpty()) {
                curr.right = stack.pop();
            }
            curr.left = null;
            curr = curr.right;
        }
    }
}
