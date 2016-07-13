package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 7/10/16.
 */
public class InOrderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        while(!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val);
            node = node.right;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}
