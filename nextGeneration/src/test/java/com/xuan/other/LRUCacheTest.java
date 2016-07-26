package com.xuan.other;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 7/25/16.
 */
public class LRUCacheTest {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                    new int[][] {
                            {1, 1, 1}, {2, 1, 1}, {2,2,-1},
                            {1, 2, 2}, {2, 2, 2}, {2, 1, 1},
                            {1, 3, 3},
                            {1, 1, 2}, {2, 1, 2},
                            {1, 4, 4},
                            {2, 2, 2},
                            {1, 5, 5},
                            {2, 3, -1},
                            {1, 6, 6},
                            {2, 1, -1},
                            {2, 4, 4},
                            {1, 7, 7},
                            {2, 2, -1}
                    }
                }
        };
    }


    @Test(dataProvider = "data")
    public void test(final int[][] operations) {
        LRUCache cache = new LRUCache(4);
        for(int[] op : operations) {
            if (op[0] == 1) {
                cache.set(op[1], op[2]);
            } else {
                int val = cache.get(op[1]);
                Assert.assertEquals(val, op[2]);
            }
        }
    }
}
