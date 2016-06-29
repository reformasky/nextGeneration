package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/25/16.
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        int index = 0;
        while(left <= right) {
            if (nums[left] != val) {
                nums[index++] = nums[left];
            } else {
                while(right > left && nums[right] == val) {
                    right--;
                }
                if (right > left) {
                    nums[index++] = nums[right--];
                }
            }
            left++;
        }
        return index;
    }
}
