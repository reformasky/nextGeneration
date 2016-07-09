package com.xuan.int_related;

/**
 * Created by xzhou2 on 7/5/16.
 */
public class Sqrt_69 {
    public int mySqrt(int x) {
        if (x < 1) {
            return x;
        }
        int high = x, low = 1;
        while(low <= high) {
            int mid = low + (high - low) /2;
            int tmp = x / mid;
            if (mid > tmp) {
                high = mid - 1;
            }
            else if (mid == tmp) {
                return mid;
            }
            else {
                low = mid + 1;
            }
        }
        return high;
    }
}
