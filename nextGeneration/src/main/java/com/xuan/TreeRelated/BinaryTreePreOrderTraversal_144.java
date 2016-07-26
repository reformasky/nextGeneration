package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 7/24/16.
 */
public class BinaryTreePreOrderTraversal_144 {
    public List<Integer> preorderTraversal_Morris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode pre, curr = root;
        while(curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while(pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    result.add(curr.val);
                    curr = curr.left;
                }
                else {
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal_stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null) {
            result.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }

            if (root.left != null) {
                root = root.left;
            } else if (! stack.isEmpty()) {
                root = stack.pop();
            } else {
                root = null;
            }

        }
        return result;
    }

}
