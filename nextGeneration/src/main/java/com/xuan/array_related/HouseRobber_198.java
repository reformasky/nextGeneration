package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/31/16.
 */
public class HouseRobber_198 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int curr = nums[1], pre = nums[0];
        for(int i = 2; i < nums.length; i++) {
            int tmp = Math.max(pre, curr);
            curr = Math.max(curr, pre + nums[i]);
            pre = tmp;
        }
        return Math.max(curr, pre);
    }
}
