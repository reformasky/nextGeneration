package com.xuan.array_related;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by xzhou2 on 7/26/16.
 */
public class MinInRotatedArray_153Test {
    @Test
    public void test() {
        for(int m = 1; m < 100; m++) {
            int n = m;
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = i;
            }
            for(int i = 0; i < n; i++) {
                int[] copy = Arrays.copyOf(nums, n);
                FindInRotatedSortedArrNoDup_33Test.rotate(copy, i);
                System.out.println(i);
                Assert.assertEquals(new MinInRotatedArray_153().findMin(copy), 0);
            }
        }

    }
}
