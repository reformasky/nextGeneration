package com.xuan.int_related;

/**
 * Created by xzhou2 on 7/4/16.
 */
public class PermutationSequence_60 {
    private int[] cache;
    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "" + 1;
        }
        cache = new int[n - 1];
        populateCache(cache, n);
        boolean[] used = new boolean[n];
        int index = 0;
        char[] result = new char[n];
        k -= 1;
        for(int i = cache.length - 1; i >= 0; i--) {
            int order = k / cache[i];
            k %= cache[i];
            for(int j = 1; j <= n; j++) {
                if (!used[j - 1]) {
                    if (order >0) {
                        order--;
                    }
                    else {
                        result[index++] =(char)( j +'0');
                        used[j - 1] = true;
                        break;
                    }
                }
            }
        }
        for(int j = 1; j <= n; j++) {
            if (!used[j-1]) {
                result[index++] = (char)( j +'0');
            }
        }
        return new String(result);
    }

    private void populateCache(int[] cache, int n) {
        cache[0] = 1;
        for(int i = 1; i < n - 1; i++) {
            cache[i] = cache[i-1] * (i + 1);
        }
    }
}
