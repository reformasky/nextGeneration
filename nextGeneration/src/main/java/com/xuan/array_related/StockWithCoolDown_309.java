package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/25/16.
 */
public class StockWithCoolDown_309 {
    public int maxProfit(int[] prices) {
        int rest = 0, sell = 0, hold = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length;i++) {
            int preSell = sell;
            sell = hold + prices[i];
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, preSell);
        }
        return Math.max(rest, sell);
    }
}
