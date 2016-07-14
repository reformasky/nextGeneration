package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Created by xzhou2 on 7/13/16.
 */
public class BTZigZagLevelTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue1 = new ArrayDeque<>(),
                queue2 = new ArrayDeque<>();
        queue1.offer(root);
        boolean removeFirst = true;
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> curr = helper(queue1, queue2, removeFirst);
            result.add(curr);
            removeFirst = !removeFirst;
        }
        return result;
    }

    private List<Integer> helper(Queue<TreeNode> queue1, Queue<TreeNode> queue2, boolean removeFirst) {
        if (queue1.isEmpty()) {
            Queue<TreeNode> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
        Integer[] temp = new Integer[queue1.size()];
        int index = removeFirst ? 0 : (queue1.size() -1);
        while(!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (removeFirst) {
                temp[index++] = node.val;
            }
            else {
                temp[index--] = node.val;
            }
        }
        return Arrays.asList(temp);
    }
}
