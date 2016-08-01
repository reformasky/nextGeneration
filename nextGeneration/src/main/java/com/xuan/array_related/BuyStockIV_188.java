package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 7/29/16.
 */
public class BuyStockIV_188 {
    public int maxProfit(int k, int[] prices) {
        int result = 0;
        if (k == 0) {
        }
        else if (k > prices.length / 2) {
            for(int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    result += prices[i] - prices[i-1];
                }
            }
        } else if (k == 1) {
            int min = Integer.MAX_VALUE;
            for(int p : prices) {
                if (p < min) {
                    min = p;
                } else {
                    result = Math.max(result, p - min);
                }
            }
        } else {
            int[] buy = new int[k],
                    sell = new int[k];
            Arrays.fill(buy, Integer.MIN_VALUE);
            for(int p : prices) {
                for(int i = k - 1; i > 0; i--) {
                    sell[i] = Math.max(sell[i], buy[i] + p);
                    buy[i] = Math.max(buy[i], sell[i-1] - p);
                }
                sell[0] = Math.max(sell[0], buy[0] + p);
                buy[0] = Math.max(buy[0], -p);
            }
            result = sell[k - 1];
        }
        return result;
    }
}
