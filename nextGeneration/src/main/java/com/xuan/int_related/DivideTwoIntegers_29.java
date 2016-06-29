package com.xuan.int_related;

/**
 * Created by xzhou2 on 6/26/16.
 */
public class DivideTwoIntegers_29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == divisor ? 1 : 0;
        }
        if (divisor < 0) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            return -divide(dividend, -divisor);
        }
        if (dividend == Integer.MIN_VALUE) {
            return -1 + divide(dividend + divisor, divisor);
        }
        if (dividend < 0) {
            return -divide(-dividend, divisor);
        }
        if (dividend < divisor) {
            return 0;
        }
        int result = 0;
        int shift = 0;
        while(divisor <= (dividend >> 1)) {
            divisor <<= 1;
            shift++;
        }
        while(shift >= 0) {
            if(dividend >= divisor) {
                result += (1<< shift);
                dividend -=divisor;
            }
            divisor >>= 1;
            shift--;
        }
        return result;
    }
}
