package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/18/16.
 */
public class StockI_121 {
    public int maxProfit(int[] prices) {
        int result = 0, min = Integer.MAX_VALUE;
        for(int p : prices) {
            min = Math.min(min, p);
            result = Math.max(result, p - min);
        }
        return result;
    }
}
