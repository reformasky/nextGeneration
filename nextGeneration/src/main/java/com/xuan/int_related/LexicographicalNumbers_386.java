package com.xuan.int_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 10/4/16.
 */
public class LexicographicalNumbers_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int curr = 1;
        while(result.size() < n) {
            result.add(curr);
            curr = next(curr, n);
        }
        return result;
    }

    private int next(int curr, int max) {
        if ( curr * 10 <= max) {
            return curr * 10;
        } else {
            int next = curr + 1;
            while(next % 10 == 0) {
                next /= 10;
            }
            return next > max ? (next/10 + 1) : next;
        }
    }
}
