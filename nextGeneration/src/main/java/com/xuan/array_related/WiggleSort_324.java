package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 9/1/16.
 */
public class WiggleSort_324 {
    int len;
    public void wiggleSort(int[] nums) {
        if (nums.length == 0) { return; }
        len = nums.length;
        int median = find(nums, nums.length / 2, 0, nums.length - 1);
        int index = 0, low = 0, high = len - 1;
        while(index <= high) {
            if (nums[getIndex(index)] > median) {
                swap(nums, getIndex(index++), getIndex(low++));
            } else if (nums[getIndex(index)] < median) {
                swap(nums, getIndex(index), getIndex(high--));
            } else {
                index++;
            }
        }
    }

    private int getIndex(int i) {
        return (2 * i + 1) % (len | 1);
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {return;}
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int find(int[] nums, int k, int low, int high) {
        if (low == high) { return nums[low];}
        int i = low, j = high + 1;
        while(true) {
            while(i < high && nums[++i] >= nums[low]);
            while(j > low && nums[--j] <= nums[low]);
            if (j <= i) {break;}
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        int tmp = nums[j];
        nums[j] = nums[low];
        nums[low] = tmp;
        if (j == k) {return nums[j];}
        else if (j > k) { return find(nums, k, low, j - 1);}
        else return find(nums, k, j + 1, high);
    }
}
