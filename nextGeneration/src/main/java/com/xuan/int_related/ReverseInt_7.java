package com.xuan.int_related;

/**
 * Created by xzhou2 on 6/20/16.
 */
public class ReverseInt_7 {
    public int reverse(int x) {
        long tmp = x,
                max = Integer.MAX_VALUE,
                min = Integer.MIN_VALUE;
        long result = 0;
        while(tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp /= 10;
        }
        if (result < min || result > max) {
            return 0;
        }
        return (int)result;
    }

    public int reverse_better(int x) {
        int result = 0;
        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
