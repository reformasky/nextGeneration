package com.xuan.other;

import java.util.Random;

/**
 * Created by xzhou2 on 10/2/16.
 */
public class RandomPick_398 {
    class Solution{
        int[] nums;
        Random rand;
        public Solution(int[] nums) {
            this.nums = nums;
            this.rand = new Random();
        }
        public int pick(int target) {
            int total = 0;
            int res = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current index. The probability is always 1/nums for the latest appeared number. For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
                    int x = rand.nextInt(++total);
                    res = x == 0 ? i : res;
                }
            }
            return res;
        }
    }
}
