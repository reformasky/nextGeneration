package com.xuan.array_related;

import org.junit.Test;

/**
 * Created by xzhou2 on 9/21/16.
 */
public class KPairsWithSmallSum_373Test {

    private final KPairsWithSmallSum_373 k = new KPairsWithSmallSum_373();
    @Test
    public void test() {
        int[] nums1 = new int[]{-10,-4,0,0,6}, nums2 = new int[]{3,5,6,7,8,100};
        int s = 100;
        int ln = 0;
        for(int[] r : k.kSmallestPairs(nums1, nums2, s)) {
            System.out.println(ln++ + "  " + r[0] + " " + r[1]);
        }

    }
}
