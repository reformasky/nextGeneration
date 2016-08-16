package com.xuan.int_related;

/**
 * Created by xzhou2 on 8/11/16.
 */
public class AddDigits_258 {
    public int addDigits(int num) {
        if (num == 0) {
            return num;
        }
        int res = num % 9;
        return res == 0 ? 9 : res;
    }
}
