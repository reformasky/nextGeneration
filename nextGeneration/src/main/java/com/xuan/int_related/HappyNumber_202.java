package com.xuan.int_related;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xzhou2 on 7/31/16.
 */
public class HappyNumber_202 {
    Set<Integer> visited = new HashSet<>();
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (visited.contains(n)) {
            return false;
        }
        visited.add(n);
        int next = 0;
        while(n > 0) {
            int r = (n % 10);
            next += r * r;
            n = n / 10;
        }
        return isHappy(next);
    }
}
