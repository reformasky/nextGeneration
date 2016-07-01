package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/29/16.
 */
public class TrapRainWater_42 {
    public int trap(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int currH = 0;
        while(left < right) {
            if (height[left] < height[right]) {
                if (height[left] < currH) {
                    result += (-height[left] + currH);
                }
                else {
                    currH = height[left];
                }
                left++;
            } else {
                if (height[right] < currH) {
                    result += (-height[right] + currH);
                }
                else {
                    currH = height[right];
                }
                right--;
            }

        }

        return result;
    }
}
