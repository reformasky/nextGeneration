package com.xuan.other;

import com.xuan.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xzhou2 on 8/22/16.
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("|,");
            return sb.toString();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                sb.append(node.val);
                sb.append(",");
                stack.push(node.right);
                stack.push(node.left);
            } else {
                sb.append("|,");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String token = queue.poll();
        if (token.charAt(0) == '|') {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}

