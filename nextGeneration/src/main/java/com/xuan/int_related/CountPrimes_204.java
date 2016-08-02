package com.xuan.int_related;

/**
 * Created by xzhou2 on 8/1/16.
 */
public class CountPrimes_204 {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int count = 1;
        boolean[] notPrime = new boolean[n];
        for(int i = 2; i < n; i += 2) {
            notPrime[i] = true;
        }
        for(int i = 3; i < n; i += 2) {
            if (! notPrime[i]) {
                count++;
                for(int j = i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return count;
    }
}
