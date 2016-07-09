package com.xuan.array_related;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 7/7/16.
 */
public class SearchInRotatedSortedArrayII_81Test {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void test() {
        Long time = System.nanoTime();
        Random random = new Random(125042996340472l);
        int n = 100;
        int[] nums = new int[n];
        SearchInRotatedSortedArrayII_81 findInRotatedSortedArrNoDup_33 = new SearchInRotatedSortedArrayII_81();
        for(int i = 0; i < n; i++) {
            nums[i] = random.nextInt(n /2);
        }
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            int[] copy = rotate(nums, i);
            for(int j = 0; j < n; j++) {
                boolean result = findInRotatedSortedArrNoDup_33.search(copy, j);
                int r = Arrays.binarySearch(nums, j);
                if (result != (r >= 0)) {
                    logger.info(time+ "");
                }
            }
        }
    }


    public int[] rotate(int[] nums, int i) {
        int[] result = new int[nums.length];
        int j;
        for(j = i; j < nums.length; j++) {
            result[j] = nums[j - i];
        }
        for(j = 0; j < i; j++) {
            result[j] = nums[nums.length - i + j];
        }
        return result;
    }
}
