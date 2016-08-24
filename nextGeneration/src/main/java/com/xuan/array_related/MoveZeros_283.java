package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/18/16.
 */
public class MoveZeros_283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for(; index < nums.length; index++) {
            nums[index] = 0;
        }
    }
}
