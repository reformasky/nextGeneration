package com.xuan.int_related;

/**
 * Created by xzhou2 on 8/31/16.
 */
public class BulbSwitch_319 {
    public int bulbSwitch(int n) {
        int result = 0;
        for(long i = 1; i * i <= (long)n; i++) {
            result++;
        }
        return result;
    }
}
