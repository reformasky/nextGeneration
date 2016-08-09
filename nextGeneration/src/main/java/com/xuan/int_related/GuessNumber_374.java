package com.xuan.int_related;

/**
 * Created by xzhou2 on 8/7/16.
 */
public class GuessNumber_374 {
    public int guessNumber(int n) {
        return guessNumber(1, n);
    }

    private int guessNumber(int low, int high) {
        if (low >= high) {
            return low;
        }
        int mid = low + (high - low)/2;
        int r = guess(mid);
        if (r > 0) {
            return guessNumber(mid + 1, high);
        } else if (r == 0) {
            return mid;
        } else {
            return guessNumber(low, mid - 1);
        }
    }

    private int guess(int i) {
        return i;
    }
}
