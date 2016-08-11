package com.xuan.int_related;

/**
 * Created by xzhou2 on 8/9/16.
 */
public class CountDigitsOne_233 {
    public int countDigitOne_cleaner(int n) {
        int result = 0;
        int m = 1, right = 0;
        while( n > 0) {
            int left = n / 10, mid = n % 10;
            if (mid == 0) {
                result += left * m;
            } else if (mid == 1) {
                result += left * m + right + 1;
            } else {
                result += (left + 1) * m;
            }
            right += mid * m;
            m *= 10;
            n /= 10;
        }
        return result;
    }


    public int countDigitOne_muchBetter(int n) {
        if (n <1) {
            return 0;
        }
        int result = 0;
        int mask = 1;
        while(true) {
            int left = n / mask / 10, mid = n / mask % 10, right = n % mask;
            if (mid == 0) {
                result += left * mask;
            } else if (mid == 1) {
                result += left * mask + right + 1;
            } else if (mid > 1){
                result += (left + 1) * mask;
            }
            if(mask > n / 10) {
                break;
            }
            mask *= 10;
        }
        return result;
    }


    public int countDigitOne(int n) {
        if (n < 1) {
            return 0;
        }
        int mask = 1;
        int[] cache = new int[11];
        cache[0] = 0;
        int index = 1;
        while(mask <= n / 10) {
            cache[index] = 10 * cache[index - 1] + mask;
            mask *= 10;
            index++;
        }
        index--;
        int result = 0;
        while(n > 0) {
            int q = n / mask;
            n = n % mask;
            result += q * cache[index];
            if (q == 1) {
                result += (n + 1);
            } else if (q > 1) {
                result += mask;
            }
            index--;
            mask /= 10;
        }

        return result;
    }
}
