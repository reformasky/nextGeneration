package com.xuan.int_related;

/**
 * Created by xzhou2 on 10/11/16.
 */
public class FindKthDigits_400 {
    public int findNthDigit(int n) {
        n--;
        int mask = 1, digits = 1;
        while(n / 9 / mask / digits > 0) {
            n -= (9 * mask * digits);
            mask *= 10;
            digits++;
        }
        int q =  n/ digits + mask;
        int r = (n ) % digits ;
        while(r-- > 0) {
            mask /= 10;
        }
        return (q / mask) % 10;
    }
}
