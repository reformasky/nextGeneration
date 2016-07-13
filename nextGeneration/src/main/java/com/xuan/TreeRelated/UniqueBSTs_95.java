package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 7/10/16.
 */
public class UniqueBSTs_95 {
    List<TreeNode>[][] cache;

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        cache = (List<TreeNode>[][])(new List[n][n]);
        return helper(1, n);
    }

    private List<TreeNode> helper(int low, int high) {
        List<TreeNode> result = new ArrayList<>();
        if (low > high) {
            return result;
        }
        if (low == high) {
            result.add(new TreeNode(low));
            return result;
        }
        if (cache[low -1][high-1] != null) {
            return cache[low-1][high-1];
        }
        for(int i = low; i <= high; i++) {
            List<TreeNode> lefts = helper(low, i - 1);
            List<TreeNode> rights = helper(i + 1, high);
            if (lefts.isEmpty()) {
                for(TreeNode r : rights) {
                    TreeNode root = new TreeNode(i);
                    root.right = r;
                    result.add(root);
                }
            }
            else {
                if (rights.isEmpty()) {
                    for (TreeNode l : lefts) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        result.add(root);
                    }
                } else {
                    for (TreeNode l : lefts) {
                        for (TreeNode r : rights) {
                            TreeNode root = new TreeNode(i);
                            root.left = l;
                            root.right = r;
                            result.add(root);
                        }
                    }
                }
            }
        }
        cache[low-1][high-1] = result;
        return result;
    }
}
