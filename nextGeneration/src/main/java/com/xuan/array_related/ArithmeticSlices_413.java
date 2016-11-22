package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 10/18/16.
 */
public class ArithmeticSlices_413 {
    private static final List<Integer> cache = new ArrayList<>(4);
    static {
        cache.add(0);
        cache.add(0);
        cache.add(0);
        cache.add(1);
    }
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int res = 0, count = 2, diff = A[1] - A[0];
        for(int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == diff) {
                count++;
            } else {
                res += lenToCount(count);
                diff = A[i] - A[i - 1];
                count = 2;
            }
        }
        res += lenToCount(count);
        return res;
    }

    private static int lenToCount(int c) {
        if (cache.size() > c) {
            return cache.get(c);
        }
        int res =  2 * lenToCount(c - 1) + 1 - lenToCount(c - 2);
        cache.add(res);
        return res;
    }
}
