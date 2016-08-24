package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/16/16.
 */
public class FirstBadVersion_278 {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while(low < high) {
            int m = low + (high - low) /2;
            if (isBadVersion(m)) {
                high = m;
            } else {
                low = m + 1;
            }
        }
        return isBadVersion(high) ? high : high + 1;
    }

    private boolean isBadVersion(int n) {
        return false;
    }
}
