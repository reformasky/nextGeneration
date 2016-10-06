package com.xuan.int_related;

/**
 * Created by xzhou2 on 9/19/16.
 */
public class Sum_371 {
    public int getSum(int a, int b) {
        int sum = 0, carryOver = 0;
        for(int i = 0; i < 32; i++) {
            int c = (a & 1), d = (b & 1);
            if ((c ^ d) != carryOver) {
                sum |= (1 << i);
            }
            carryOver = (c & d) | (c & carryOver) | (d & carryOver);
            a >>= 1;
            b >>= 1;
        }
        return sum;
    }
}
