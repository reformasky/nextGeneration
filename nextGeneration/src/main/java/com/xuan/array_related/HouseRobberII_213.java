package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/2/16.
 */
public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int low, int high) {
        int curr = 0, pre = 0;
        for(int i = low; i < high; i++) {
            int tmp = Math.max(curr, pre);
            curr = Math.max(curr, pre + nums[i]);
            pre = tmp;
        }
        return curr;
    }
}
