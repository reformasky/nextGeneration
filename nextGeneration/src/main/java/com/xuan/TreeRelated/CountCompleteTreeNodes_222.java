package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 8/5/16.
 */
public class CountCompleteTreeNodes_222 {

    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                        : (1 << h-1) + countNodes(root.left);
    }
    public int countNodes_Iterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1, right = 1, mid = 1;
        TreeNode node = root.left;
        while(node != null) {
            left++;
            node = node.left;
        }
        node = root.right;
        while(node != null) {
            right++;
            node = node.right;
        }
        if(left == right) {
            return (1 << left) - 1;
        }
        node = root.left;
        while(node != null) {
            mid++;
            node = node.right;
        }
        if (mid == left) {
            return 1 + (1 << (left - 1) - 1) + countNodes(root.right);
        } else {
            return 1 + (1 << (right - 1) + 1) + countNodes(root.left);
        }
    }

}
