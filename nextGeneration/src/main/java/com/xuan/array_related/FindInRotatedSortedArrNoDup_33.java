package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/27/16.
 */
public class FindInRotatedSortedArrNoDup_33 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        }
        int mid = begin + (end - begin)/2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            if (nums[mid] >= nums[begin]) {
                return search(nums, mid + 1, end, target);
            }
            else {
                if (target > nums[end]) {
                    return search(nums, begin, mid - 1, target);
                }
                else {
                    return search(nums, mid + 1, end, target);
                }
            }
        }
        else {
            if (nums[mid] <= nums[end]) {
                return search(nums, begin, mid - 1, target);
            }
            else {
                if (target >= nums[begin]) {
                    return search(nums, begin, mid - 1, target);
                }
                else {
                    return search(nums, mid + 1, end, target);
                }
            }
        }
    }
}
