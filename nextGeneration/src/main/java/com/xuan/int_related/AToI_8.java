package com.xuan.int_related;

/**
 * Created by xzhou2 on 6/20/16.
 */
public class AToI_8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }else if (str.charAt(index) == '+') {
            sign = 1;
            index++;
        }
        int result = 0, bound = Integer.MAX_VALUE / 10;
        for(;index < str.length(); index++) {
            if (!isDigit(str.charAt(index))) {
                return sign * result;
            }
            int d = str.charAt(index) - '0';
            boolean outFlow = (result > bound ) || (result == bound && d >= 8);
            if (outFlow) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + d;
        }
        return sign * result;

    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
