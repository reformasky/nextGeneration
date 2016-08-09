package com.xuan.array_related;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xzhou2 on 8/3/16.
 */
public class SkyLine_218Test {
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
/*                {
                        new int[][]{new int[]{2, 9, 10}, new int[]{3, 7, 15}, new int[]{5, 7, 12}, new int[]{15, 20, 10}, new int[]{19, 24, 8}}
                },*/
                {
                        new int[][]{
                              //  new int[]{2, 9, 10}, new int[]{2, 8, 10}, new int[]{2, 8, 11}, new int[]{2, 8, 9}, new int[]{2, 10, 10}, new int[]{2, 10, 9}, new int[]{2, 10, 11},
                              // new int[]{3, 9, 12}, new int[]{4, 8, 13}
                                new int[]{1,3,3}, new int[]{2,2, 4}, new int[]{3,8,3} , new int[]{4,5, 2}, new int[]{5, 6, 9}
                        }

                }
        };
    }

    @Test(dataProvider = "data")
    public void test(int[][] buildings) {
        SkyLine_218 skyLine = new SkyLine_218();
        List<int[]> res = skyLine.getSkyline(buildings);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int[] r : res) {
            sb.append("[" + r[0] + "," + r[1] + "],");
        }
        sb.append(']');
        System.out.println(sb.toString());
    }
}
