package com.xuan.int_related;

/**
 * Created by xzhou2 on 9/1/16.
 */
public class PowerOfFour_342 {
    public boolean isPowerOfFour(int num) {
        if(num <= 0) { return false;}
        if (num != (num & -num)) {return false;}
        if ((num & 0x55555555) == 0) { return false;}
        return true;
    }
}
