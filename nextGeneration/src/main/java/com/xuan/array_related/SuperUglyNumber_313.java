package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/28/16.
 */
public class SuperUglyNumber_313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        int[] indexes = new int[primes.length];
        res[0] = 1;
        int index = 1;
        while(index < n) {
            int next = findNext(indexes, primes, res);
            resetIndex(indexes, primes, res, next);
            res[index++] = next;
        }
        return res[n - 1];
    }

    private int findNext(int[] indexes, int[] primes, int[] res) {
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < indexes.length; i++) {
            int curr = primes[i] * res[indexes[i]];
            result = Math.min(result, curr);
        }
        return result;
    }

    private void resetIndex(int[] indexes, int[] primes, int[] res, int next) {
        for(int i = 0; i < indexes.length; i++) {
            if (primes[i] * res[indexes[i]] == next) {
                indexes[i]++;
            }
        }
    }
}
