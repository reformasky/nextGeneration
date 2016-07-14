package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xzhou2 on 7/13/16.
 */
public class BTLevelTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue1 = new ArrayDeque<>(),
                queue2 = new ArrayDeque<>();
        queue1.offer(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> curr = helper(queue1, queue2);
            if (!curr.isEmpty()) {
                result.add(curr);
            }
        }
        return result;
    }

    private List<Integer> helper(Queue<TreeNode> queue1, Queue<TreeNode> queue2) {
        List<Integer> result = new ArrayList<>();
        if (queue1.isEmpty()) {
            Queue<TreeNode> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
        while (!queue1.isEmpty()) {
            TreeNode curr = queue1.poll();
            result.add(curr.val);
            if (curr.left != null) {
                queue2.offer(curr.left);
            }
            if (curr.right != null) {
                queue2.offer(curr.right);
            }
        }
        return result;
    }
}
