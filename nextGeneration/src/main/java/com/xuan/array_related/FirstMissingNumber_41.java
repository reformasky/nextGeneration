package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/29/16.
 */
public class FirstMissingNumber_41 {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while(curr > 0 && curr <= nums.length && nums[curr - 1] != curr) {
                int tmp = nums[curr - 1];
                nums[curr - 1] = curr;
                curr = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
