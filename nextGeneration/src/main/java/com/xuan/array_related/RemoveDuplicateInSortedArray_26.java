package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/25/16.
 */
public class RemoveDuplicateInSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for(int i = 1; i < nums.length;i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
