package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/18/16.
 */
public class StockIII_123 {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE,
                sell1 = 0, sell2 = 0;
        for(int p : prices) {
            sell2 = Math.max(buy2 + p, sell2);
            buy2 = Math.max(sell1 - p, buy2);
            sell1 = Math.max(buy1 + p, sell1);
            buy1 = Math.max(buy1, -p);
        }
        return Math.max(sell1, sell2);
    }
}
