package com.xuan.array_related;

/**
 * Created by xzhou2 on 9/7/16.
 */
public class IncreasingTriplets_334 {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int n : nums) {
            if (n <= first) {
                first = n;
            } else if (n < second) {
                second = n;
            } else if (n > second) {
                return true;
            }
        }
        return false;
    }
}
