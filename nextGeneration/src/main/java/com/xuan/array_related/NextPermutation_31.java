package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/26/16.
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        for(int index = nums.length - 2; index >= 0; index--) {
            if (nums[index] >= nums[index+ 1]) {
                continue;
            }
            for(int i = nums.length - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    int tmp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = tmp;
                    reverse(nums, index + 1, nums.length -1);
                    return;
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        while(begin < end) {
            int tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
            begin++;
            end--;
        }
    }
}
