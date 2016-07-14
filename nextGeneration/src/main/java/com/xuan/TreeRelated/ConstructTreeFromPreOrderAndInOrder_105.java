package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.Stack;

/**
 * Created by xzhou2 on 7/13/16.
 */
public class ConstructTreeFromPreOrderAndInOrder_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]),
                curr = root;
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 1, j = 0; i < preorder.length; i++) {
            if (curr.val != inorder[j]) {
                curr.left = new TreeNode(preorder[i]);
                stack.push(curr);
                curr = curr.left;
            }
            else {
                j++;
                while(!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    curr = stack.pop();
                    j++;
                }
                curr = curr.right = new TreeNode(preorder[i]);
            }
        }
        return root;
    }

    public TreeNode buildTree_recursive(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int lowP, int highP, int[] inorder, int lowI, int highI) {
        if (lowP == highP) {
            return new TreeNode(preorder[lowP]);
        }
        if (lowP > highP) {
            return null;
        }
        TreeNode result = new TreeNode(preorder[lowP]);
        int index = findIndex(inorder, lowI, highI, preorder[lowP]);
        int leftSize = index - lowI;
        result.left = buildTree(preorder, lowP + 1, lowP + leftSize, inorder, lowI, index -1);
        result.right = buildTree(preorder, lowP + leftSize + 1, highP, inorder, index + 1, highI);
        return result;
    }

    private int findIndex(int[] inorder, int low, int high, int target) {
        for(int i = low; i <= high; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
