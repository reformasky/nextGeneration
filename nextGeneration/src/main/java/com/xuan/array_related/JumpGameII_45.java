package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/30/16.
 */
public class JumpGameII_45 {
    public int jump(int[] nums) {
        int currMax = 0, lastMax = -1;
        int result = 0;
        while(currMax < nums.length - 1) {
            result++;
            int max = currMax;
            for(int i = lastMax + 1; i <= max; i++) {
                int tmp = nums[i] + i;
                if (tmp > currMax) {
                    currMax = tmp;
                }
            }
            lastMax = max;
        }
        return result;
    }
}
