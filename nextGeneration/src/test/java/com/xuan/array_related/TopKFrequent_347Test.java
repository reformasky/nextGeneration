package com.xuan.array_related;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 9/8/16.
 */
public class TopKFrequent_347Test {
    private static final TopKFrequent_347 t = new TopKFrequent_347();
    private static final Random random = new Random();

    @Test
    public void testTopK() {
        int size = 100;
        int[] nums = new int[size];
        for(int i = 0; i < size; i++) {
            nums[i] = random.nextInt(size * 3 / 2);
        }
        int[] sorted = Arrays.copyOf(nums,size);
        Arrays.sort(sorted);
        for(int k = 0; k < size; k++) {
            int[] copy = Arrays.copyOf(nums, size);
            int val = t.topK(copy, 0, size - 1, k);
            Assert.assertEquals(val, sorted[size - 1 - k]);
        }
    }
}
