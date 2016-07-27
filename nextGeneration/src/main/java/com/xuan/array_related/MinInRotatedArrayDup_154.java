package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/26/16.
 */
public class MinInRotatedArrayDup_154 {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return Math.min(nums[low], nums[high]);
    }
}
