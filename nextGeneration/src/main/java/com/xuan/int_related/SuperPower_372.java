package com.xuan.int_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 9/21/16.
 */
public class SuperPower_372 {
    private static final int NUM = 1337;
    private final int[] cacheBase = new int[10];
    private final int[] cacheR = new int[NUM];
    public int superPow(int a, int[] b) {
        buildCache(a);
        Arrays.fill(cacheR, -1);
        int res = 1;
        for(int i = 0; i < b.length; i++) {
            res = getMod(res, b[i]);
        }
        return res;
    }


    private int getMod(int res, int next) {
        res = get10Power(res);
        return (cacheBase[next] * res) % NUM;
    }

    private int get10Power(int n) {
        if (cacheR[n] != -1) {
            return cacheR[n];
        }

        int res = getPower(n, 10);
        cacheR[n] = res;
        return res;
    }

    private int getPower(int base, int power) {
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return base;
        }
        int pre = getPower(base, power/2);
        if (power % 2 == 0) {
            return (pre * pre) % NUM;
        } else {
            return (((pre * pre) % NUM )* base) % NUM;
        }
    }


    private void buildCache(int a) {
        cacheBase[0] = 1;
        for(int i = 1; i < 10; i++) {
            cacheBase[i] = (cacheBase[i - 1]  * (a % NUM)) % NUM;
        }
    }
}
