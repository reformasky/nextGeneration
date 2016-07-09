package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/7/16.
 */
public class RemoveDuplicateFromSortedArray_80 {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        if (nums.length == 0) {
            return result;
        }
        result++;
        int curr = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == curr) {
                if (count++ < 2) {
                    nums[result++] = curr;
                }
            }
            else {
                curr = nums[i];
                nums[result++] = curr;
                count = 1;
            }
        }
        return result;
    }
}
