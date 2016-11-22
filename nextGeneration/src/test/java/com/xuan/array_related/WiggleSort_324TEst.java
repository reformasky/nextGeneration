package com.xuan.array_related;

import com.xuan.util.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xzhou2 on 9/1/16.
 */
public class WiggleSort_324Test {
    @Test
    public void testFind() {
        int n = 10;
        int[] num = new int[n];
        WiggleSort_324 w = new WiggleSort_324();
        Random random = new Random();
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                num[i] = random.nextInt(n + n / 2);
            }
            int[] copy = Arrays.copyOf(num,n);
            w.wiggleSort(copy);
            copy = null;
        }

    }

    @Test
    public void testFind_1() {
        int[] num = new int[]{4, 10, 5, 10, 9, 2, 0, 2, 11, 8};
        WiggleSort_324 w = new WiggleSort_324();
        w.find(num, 0, 0, num.length - 1);
    }
}
