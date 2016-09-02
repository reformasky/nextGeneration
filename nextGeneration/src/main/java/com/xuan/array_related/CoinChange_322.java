package com.xuan.array_related;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 8/31/16.
 */
public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        for(int a = 1; a <= amount; a++) {
            for(int coin : coins) {
                if (coin <= a && cache[a - coin] != -1) {
                    cache[a] = cache[a] != -1 ? Math.min(cache[a], cache[a - coin] + 1) : (cache[a - coin] + 1);
                }
            }
        }
        return  cache[amount];
    }
}
