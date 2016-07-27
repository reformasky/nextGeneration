package com.xuan.array_related;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;


/**
 * Created by xzhou2 on 6/27/16.
 */
public class FindInRotatedSortedArrNoDup_33Test {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void test() {
        int n = 10;
        int[] nums = new int[10];
        FindInRotatedSortedArrNoDup_33 findInRotatedSortedArrNoDup_33 = new FindInRotatedSortedArrNoDup_33();
        for(int i = 0; i < n; i++) {
            nums[i] = i * 2;
        }
        for(int i = 0; i < n; i++) {
            int[] copy = rotate(nums, i);
            for(int j = 0; j < 2 * n; j++) {
                int index = findInRotatedSortedArrNoDup_33.search(copy, j);
                int exp = -1;
                for(int k = 0; k < n; k++) {
                    if (copy[k] == j) {
                        exp = k;
                        break;
                    }
                }
                Assert.assertEquals(exp, index);
                logger.info("i={}, j={}, index={}, exp={}", new String[]{i+"", j+"", index+"", exp+""});
            }
        }
    }


    public static int[] rotate(int[] nums, int i) {
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
