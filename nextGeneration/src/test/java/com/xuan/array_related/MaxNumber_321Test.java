package com.xuan.array_related;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by xzhou2 on 8/31/16.
 */
public class MaxNumber_321Test {
    @Test
    public void testMax() {
        int n = 10;
        Random random = new Random();
        int[] num = new int[n];
        for(int i = 0; i < n; i++) {num[i] = random.nextInt(15);}
        log(num);

//        MaxNumber_321 m = new MaxNumber_321();
//        for(int k = 0; k <= n; k++) {
//            int[] res = m.max(num, k);
//            log(res);
//        }
    }


    private void log(int [] res) {
        for(int i : res) {
            System.out.print(i + " ");

        }
        System.out.println();
    }
}
