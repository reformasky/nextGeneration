package com.xuan.array_related;

/**
 * Created by xzhou2 on 9/7/16.
 */
public class IntegerBreak_343 {
    public int integerBreak(int n) {
        if (n < 4) {return n - 1;}
        if (n == 4) {return n;}
        return 3 * (n > 7 ? integerBreak(n - 3) : (n - 3));
    }
}
