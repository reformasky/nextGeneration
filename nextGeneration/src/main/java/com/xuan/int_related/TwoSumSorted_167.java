package com.xuan.int_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 10/19/16.
 */
public class TwoSumSorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++) {
            int next = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if (next > i) {
                return new int[] {i + 1, next + 1};
            }
        }
        throw new RuntimeException();
    }
}
