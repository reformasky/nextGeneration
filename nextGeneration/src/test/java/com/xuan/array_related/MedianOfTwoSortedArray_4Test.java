package com.xuan.array_related;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by xzhou2 on 6/17/16.
 */
public class MedianOfTwoSortedArray_4Test {
    @Test
    public void testFindKth() {
        int n = 101;
        double r = 50.0;
        Random random = new Random();
        MedianOfTwoSortedArray_4 m = new MedianOfTwoSortedArray_4();
        for(int i = 0; i < n; i++) {
            int[] nums1 = new int[i];
            int[] nums2 = new int[n - i];
            int count1 = 0, count2 = 0;
            for(int j = 0; j < n; j++) {
               if (count1 < i && count2 < n - i) {
                   boolean flag = random.nextBoolean();
                   if (flag) {
                       nums1[count1++] = j;
                   }
                   else {
                       nums2[count2++] = j;
                   }
               }
               else if (count1 >= i) {
                   nums2[count2++] = j;
               }
               else {
                   nums1[count1++] = j;
               }
            }
            Assert.assertEquals(m.findMedianSortedArrays(nums1, nums2), r);
        }
    }
}
