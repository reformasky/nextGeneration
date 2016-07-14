package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 7/14/16.
 */
public class ConstructTreeFromInorderAndPostorder_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for(int i = 0;i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(Map<Integer, Integer> map, int lowI, int highI, int[] postorder, int lowP, int highP) {
        if (lowP == highP) {
            return new TreeNode(postorder[highP]);
        }
        if (lowP > highP) {
            return null;
        }
        int index = map.get(postorder[highP]);
        int size = index - lowI;
        TreeNode root = new TreeNode(postorder[highP]);
        root.left = buildTree(map, lowI, index - 1, postorder, lowP, lowP + size - 1);
        root.right = buildTree(map, index + 1, highI, postorder, lowP + size, highP - 1);
        return root;
    }
}
