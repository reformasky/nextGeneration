package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 7/10/16.
 */
public class DecodingWays {
    int[] cache;
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return helper(arr, 0);
    }

    private int helper(char[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        if (cache[index] >= 0) {
            return cache[index];
        }
        if (arr[index] == '0') {
            cache[index] = 0;
            return 0;
        }
        else if (index == arr.length -1) {
            cache[index] = 1;
            return 1;
        }
        if (arr[index] == '1' || (arr[index] == '2' && arr[index + 1] < '7')) {
            cache[index] =  helper(arr, index + 1) + (index < arr.length - 2 ?helper(arr, index + 2) : 1);
        }
        else {
            cache[index] =  helper(arr, index + 1);
        }
        return cache[index];
    }
}
