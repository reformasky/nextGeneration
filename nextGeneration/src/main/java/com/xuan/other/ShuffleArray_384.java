package com.xuan.other;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 10/3/16.
 */
public class ShuffleArray_384 {
    class Solution {
        int[] nums;
        Random random;
        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] copy = Arrays.copyOf(nums, nums.length);
            for(int i = 1; i < copy.length; i++) {
                int index = random.nextInt(i + 1);
                if (index != i) {
                    int tmp = copy[i];
                    copy[i] = copy[index];
                    copy[index] = tmp;
                }
            }
            return copy;
        }
    }
}
