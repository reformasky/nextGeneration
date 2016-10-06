package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 9/8/16.
 */
public class HouseRobberIII_337 {
    Map<TreeNode, Integer> taken = new HashMap<>(),
            nonTaken = new HashMap<>();
    public int rob(TreeNode root) {
        return Math.max(rob(root, true), rob(root, false));
    }

    private int rob(TreeNode root, boolean allowed) {
        if (root == null) {return 0;}
        int val;
        if (allowed) {
            if (taken.containsKey(root)) {return taken.get(root);}
            int left = rob(root.left, false), right = rob(root.right, false);
            val = left + right + root.val;
            taken.put(root, val);
        } else {
            if (nonTaken.containsKey(root)){return nonTaken.get(root);}
            int left = Math.max(rob(root.left, true), rob(root.left, false)),
                    right = Math.max(rob(root.right, true), rob(root.right, false));
            val = left + right;
            nonTaken.put(root, val);
        }
        return val;
    }
}
