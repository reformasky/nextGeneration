package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/1/16.
 */
public class MinRangeSubArraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int acc = 0, low = 0, len = nums.length;
        for(int i = 0; i < nums.length; i++) {
            acc += nums[i];
            while(low < i && acc - nums[low] >= s) {
                acc -= nums[low++];
            }
            if (acc >= s) {
                len = Math.min(len, i - low + 1);
                if (len == 1) {
                    return 1;
                }
            }
        }
        return acc >= s ? len : 0;
    }
}
