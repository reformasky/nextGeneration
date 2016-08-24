package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/18/16.
 */
public class FindDuplicateNumbers_287 {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) /2;
            int countLow = 0, countEq = 0;
            for(int num : nums) {
                if (num == mid) {
                    countEq++;
                } else if (num < mid) {
                    countLow++;
                }
            }
            if (countEq > 1) {
                return mid;
            }
            if (countLow >= mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        throw new RuntimeException();
    }
}
