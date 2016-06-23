package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/21/16.
 */
public class ContainsMostWater_11 {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int result = 0;
        int maxLeft= 0, maxRight = 0;

        for(int j = height.length - 1; j > 0 ; j--) {
            while(j > 0 && height[j] <= maxRight) {
                j--;
            }
            maxRight = height[j];
            maxLeft = 0;
            for(int i = 0; i < j; i++) {
                if (height[i] <= maxLeft) {
                    continue;
                }
                maxLeft = height[i];
                result = Math.max(result, Math.min(maxLeft, maxRight) * (j - i));
                if (maxLeft >= maxRight) {
                    break;
                }
            }
        }
        return result;
    }
}
