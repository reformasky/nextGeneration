package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/26/16.
 */
public class MaxProduct_152 {
    public int maxProduct(int[] nums) {
        int pos = 1, neg = 1;
        int result = nums[0];
        for(int i : nums) {
            // System.out.println(i + " " + pos + " " + neg);
            if (i == 0) {
                pos = 1;
                neg = 1;
                result = Math.max(result, i);
            } else if (i > 0){
                pos *= i;
                if (neg < 0) {
                    neg *= i;
                } else {
                    neg = 1;
                }
                result = Math.max(result, pos);
            } else {
                int tmp = neg;
                neg = pos * i;
                if (tmp < 0) {
                    pos = tmp * i;
                    result = Math.max(result, pos);
                } else {
                    pos = 1;
                }
            }
        }
        return result;
    }
}
