package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 7/4/16.
 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int carryOver = 1;
        List<Integer> temp = new ArrayList<>(digits.length + 1);
        for(int i = digits.length - 1; i >= 0; i--) {
            int curr = digits[i] + carryOver;
            temp.add(curr % 10);
            carryOver = curr / 10;
        }
        if (carryOver != 0) {
            temp.add(carryOver);
        }
        int[] result = new int[temp.size()];
        for(int i = 0; i < result.length;i++) {
            result[i] = temp.get(temp.size() - 1 - i);
        }
        return result;
    }
}
