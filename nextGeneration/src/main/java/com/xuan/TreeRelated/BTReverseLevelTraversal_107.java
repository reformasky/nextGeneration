package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xzhou2 on 7/14/16.
 */
public class BTReverseLevelTraversal_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue1 = new ArrayDeque<>(),
                queue2 = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue1.offer(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            stack.push(helper(queue1, queue2));
        }
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private List<Integer> helper(Queue<TreeNode> queue1, Queue<TreeNode> queue2) {
        if (queue1.isEmpty()) {
            Queue<TreeNode> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        List<Integer> result = new ArrayList<>(queue1.size());
        while(!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            result.add(node.val);
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
        }
        return result;
    }
}
