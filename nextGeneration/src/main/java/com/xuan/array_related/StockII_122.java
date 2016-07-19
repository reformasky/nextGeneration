package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/18/16.
 */
public class StockII_122 {
    public int maxProfit(int[] prices) {
        int result = 0, t = Integer.MAX_VALUE;
        for(int p : prices) {
            if (p > t) {
                result += (p - t);
            }
            t = p;
        }
        return result;
    }
}
