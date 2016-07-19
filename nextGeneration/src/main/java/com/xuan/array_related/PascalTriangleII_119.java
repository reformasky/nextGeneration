package com.xuan.array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/16/16.
 */
public class PascalTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(),
                temp = null;
        if (rowIndex < 1) {
            return Arrays.asList(1);
        }

        for(int i = 1; i <= rowIndex; i++) {
            result = new ArrayList<>(i +1);
            result.add(1);
            for(int j = 1; j < i; j++) {
                result.add(temp.get(j) + temp.get(j-1));
            }
            result.add(1);
            temp = result;
        }
        return result;
    }
}
