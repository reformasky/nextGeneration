package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 7/24/16.
 */
public class BinaryTreePostOrderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr, pre = root;
        while(!stack.isEmpty()) {
            curr = stack.peek();
            if (pre == curr.right) {
                result.add(curr.val);
                pre = stack.pop();
            } else if (pre == curr.left) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    result.add(curr.val);
                    pre = stack.pop();
                }
            } else {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    result.add(curr.val);
                    pre = stack.pop();
                }
            }
        }
        return result;
    }
}
