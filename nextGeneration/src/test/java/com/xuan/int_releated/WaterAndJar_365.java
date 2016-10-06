package com.xuan.int_releated;

/**
 * Created by xzhou2 on 9/14/16.
 */
public class WaterAndJar_365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x == 0 && y == 0) {
            return z == 0;
        }
        int g = gcd(x, y);
        return (z <= x + y) && (z % g == 0);
    }

    private int gcd(int x, int y) {
        while(y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}
