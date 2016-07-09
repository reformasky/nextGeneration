package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/6/16.
 */
public class SortColors_75 {
    public void sortColors_bucket(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int count0 = 0, count1=0;
        for(int num : nums) {
            if (num == 0) {
                count0++;
            }
            if (num == 1) {
                count1++;
            }
        }
        for(int i = 0; i < count0;i++) {
            nums[i] = 0;
        }
        for(int i = count0; i < count0 + count1; i++) {
            nums[i] = 1;
        }
        for(int i = count0 + count1; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for(int i = 0; i <= two; i++) {
            while (nums[i] == 2 && i < two) {
                swap(nums, i, two--);
            }
            while (nums[i] == 0 && i > zero) {
                swap(nums, i, zero++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
