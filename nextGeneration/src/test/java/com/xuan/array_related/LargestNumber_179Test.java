package com.xuan.array_related;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by xzhou2 on 7/28/16.
 */
public class LargestNumber_179Test {
    @Test
    public void test() {
       /* Random random = new Random();*/
        int n = 5;
        int[] nums = new int[] //{2, 216, 2060, 273, 2313, 2362};
        // {2,216, 206, 236};
       {4704,6306,9385,7536,3462,4798,5422,5529,8070,6241,9094,7846,663,6221,216,6758,8353,3650,3836,8183,3516,5909,6744,1548,5712,2281,3664,7100,6698,7321,4980,8937,3163,5784,3298,9890,1090,7605,1380,1147,1495,3699,9448,5208,9456,3846,3567,6856,2000,3575,7205,2697,5972,7471,1763,1143,1417,6038,2313,6554,9026,8107,9827,7982,9685,3905,8939,1048,282,7423,6327,2970,4453,5460,3399,9533,914,3932,192,3084,6806,273,4283,2060,5682,2,2362,4812,7032,810,2465,6511,213,2362,3021,2745,3636,6265,1518,8398};
       /* for(int i = 0; i < n-1; i++) {
            nums[i] = random.nextInt(100);
        }
        nums[n-1] = 10;*/

        String result = new LargestNumber_179().largestNumber(nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(result);
    }
}
