package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 8/11/16.
 */
public class BinaryTreePath_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, new StringBuilder(), result);
        return result;
    }

    private void dfs(TreeNode root, StringBuilder sb, List<String> result) {
        int len = sb.length();
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            result.add(sb.toString());
            sb.delete(len, sb.length());
        } else {
            sb.append(root.val);
            sb.append("->");
            if (root.left != null) {
                dfs(root.left, sb, result);
            }
            if (root.right != null) {
                dfs(root.right, sb, result);
            }
            sb.delete(len, sb.length());
        }
    }
}
