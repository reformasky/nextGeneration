package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 7/9/16.
 */
public class GrayCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int i = 1; i <= n; i++) {
            int size = result.size();
            int mask = (1 << (i  - 1));
            for(int j = size - 1; j >= 0; j--) {
                result.add((mask | result.get(j)));
            }
        }
        return result;
    }
}
