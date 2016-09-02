package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 8/31/16.
 */
public class MaxNumber_321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        Arrays.fill(res, Integer.MIN_VALUE);
        int m = nums1.length, n = nums2.length;
        for(int i = Math.max(k - n, 0); i <= Math.min(m, k); i++) {
            int[] res1 = max(nums1, i), res2 = max(nums2, k - i);
            int[] curr = merge(res1, res2);
            if (larger(curr,0, res, 0)) { res = curr;}
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int index1 = 0, index2 = 0, index = 0;
        while(index1 < nums1.length && index2 < nums2.length) {
            if (larger(nums1, index1, nums2, index2)) {res[index++] = nums1[index1++];}
            else {res[index++] = nums2[index2++]; }
        }
        while(index1 < nums1.length) { res[index++] = nums1[index1++];}
        while(index2 < nums2.length) { res[index++] = nums2[index2++];}
        return res;
    }


    private boolean larger(int[] nums1, int index1, int[] nums2, int index2) {
        while(index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > nums2[index2]) { return true;}
            else if (nums1[index1] < nums2[index2]) {return false;}
            index1++;
            index2++;
        }
        return index1 != nums1.length;
    }


    public int[] max(int[] nums, int k) {
        int[] res = new int[k];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            int minIndex = k - (nums.length - i);
            while(index > 0 && index > minIndex && res[index - 1] < nums[i]) {index--;}
            if (index < k) {
                res[index++] = nums[i];
            }
        }
        return res;
    }
}
