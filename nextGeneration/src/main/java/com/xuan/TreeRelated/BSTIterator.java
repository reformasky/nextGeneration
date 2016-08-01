package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.Stack;

/**
 * Created by xzhou2 on 7/28/16.
 */
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        int result = curr.val;
        if (curr.right != null) {
            curr = curr.right;
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return result;
    }
}
