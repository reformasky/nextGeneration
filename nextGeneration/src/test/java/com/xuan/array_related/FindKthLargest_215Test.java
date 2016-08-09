package com.xuan.array_related;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 8/3/16.
 */
public class FindKthLargest_215Test {
    @Test
    public void test() {
        Random random = new Random();
        int n = 10;
        int[] nums = new int[n];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < n; j++) {
                nums[j] = random.nextInt(n);
            }
            int[] sorted = Arrays.copyOf(nums, n);
            Arrays.sort(sorted);
            for(int k = 1; k <= n; k++) {
                int[] copy = Arrays.copyOf(nums, n);
                int r = new FindKthLargest_215().findKthLargest(copy, k);
                Assert.assertEquals(r, sorted[n - k]);
            }
        }
    }
}
