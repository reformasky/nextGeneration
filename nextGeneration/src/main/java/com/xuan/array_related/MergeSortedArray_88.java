package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/9/16.
 */
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m-1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        int index = 0, index1 = 0, index2 = 0;
        while(index1 < m && index2 < n) {
            if (nums1[index1 + n] < nums2[index2]) {
                nums1[index++] = nums1[n + (index1++)];
            }
            else {
                nums1[index++] = nums2[index2++];
            }
        }
        while(index1 < m) {
            nums1[index++] = nums1[n + (index1++)];
        }
        while(index2 < n) {
            nums1[index++] = nums2[index2++];
        }
    }
}
