package com.xuan.TreeRelated;

import com.xuan.util.TreeNode;

/**
 * Created by xzhou2 on 7/14/16.
 */
public class SortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return new TreeNode(nums[low]);
        }
        int mid = low + (high - low) /2;
        TreeNode result = new TreeNode(nums[mid]);
        result.left = sortedArrayToBST(nums, low , mid -1);
        result.right = sortedArrayToBST(nums, mid + 1, high);
        return result;
    }
}
