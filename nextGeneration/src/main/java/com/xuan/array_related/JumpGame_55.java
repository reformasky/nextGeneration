package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/2/16.
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int pre = -1, max = 0;
        while(max < nums.length -1) {
            int tmp = max;
            boolean canJump = false;
            for(int i = pre + 1; i <= tmp; i++) {
                int next = i + nums[i];
                if (next > max) {
                    canJump = true;
                    max = next;
                }
            }
            if (!canJump) {
                return false;
            }
            pre = tmp;
        }
        return true;
    }
}
