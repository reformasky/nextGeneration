package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 7/15/16.
 */
public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, sum, result, new ArrayList<Integer>());
        return result;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                path.add(root.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() -1);
            }
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            helper(root.left, sum - root.val, result, path);
        }
        if (root.right != null) {
            helper(root.right, sum - root.val, result, path);
        }
        path.remove(path.size() -1);
    }
}
