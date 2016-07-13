package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.HashMap;

/**
 * Created by xzhou2 on 7/11/16.
 */
public class IsValidBST_98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }




    /*HashMap<TreeNode, int[]> map = new HashMap<>();;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            int[] l = helper(root.left);
            if (!isValidBST(root.left) || l[1] >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            int[] r = helper(root.right);
            if (!isValidBST(root.right) || r[0] <= root.val) {
                return false;
            }
        }
        return true;
    }

    private int[] helper(TreeNode root) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int[] result = new int[2];
        result[0] = root.val;
        result[1] = root.val;
        if (root.left != null) {
            result[0] = helper(root.left)[0];
        }
        if (root.right != null) {
            result[1] = helper(root.right)[1];
        }
        map.put(root, result);
        return result;
    }*/
}
