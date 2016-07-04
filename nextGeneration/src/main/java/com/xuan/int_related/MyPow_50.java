package com.xuan.int_related;

/**
 * Created by xzhou2 on 7/1/16.
 */
public class MyPow_50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            return 1.0/ x /myPow(x, Integer.MAX_VALUE);
        }
        if (n < 0) {
            return 1.0/myPow(x, -n);
        }
        double tmp =myPow(x, n /2);

        if ( n % 2 == 0) {
            return tmp * tmp ;
        }
        else {
            return x * tmp * tmp;
        }
    }
}
