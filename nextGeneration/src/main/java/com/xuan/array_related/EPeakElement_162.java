package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/26/16.
 */
public class EPeakElement_162 {
    public int findPeakElement(int[] nums) {
        int pre = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i];
            if (curr > pre && curr > nums[i + 1]) {
                return i;
            }
            pre = curr;
        }
        return nums.length - 1;
    }
}
