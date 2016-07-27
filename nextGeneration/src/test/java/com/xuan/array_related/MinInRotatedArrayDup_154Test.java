package com.xuan.array_related;

import com.xuan.util.RandomListNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 7/26/16.
 */
public class MinInRotatedArrayDup_154Test {
    @Test
    public void test() {

        Random random = new Random();
        for(int j = 0; j < 1000; j++) {
            for(int m = 5; m < 100; m++) {
                int n = m;
                int[] nums = new int[n];
                for(int i = 0; i < n; i++) {
                    nums[i] = i;
                    if (random.nextBoolean() && i > 0) {
                        nums[i] = nums[i-1];
                    }
                }
                for(int i = 0; i < n; i++) {
                    int[] copy = Arrays.copyOf(nums, n);

                    Assert.assertEquals(new MinInRotatedArrayDup_154().findMin(FindInRotatedSortedArrNoDup_33Test.rotate(copy, i)), nums[0]);
                }
            }
        }


    }
}
