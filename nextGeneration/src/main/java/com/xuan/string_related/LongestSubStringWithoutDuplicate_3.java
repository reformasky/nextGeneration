package com.xuan.string_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 6/16/16.
 */
public class LongestSubStringWithoutDuplicate_3 {
    private static final int SIZE = 256;
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() ==0) {
            return 0;
        }
        int start = 0;
        int result = 1;
        int[] indexes = new int[SIZE];
        Arrays.fill(indexes, -1);
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            if (indexes[index] >= start) {
                result = Math.max(result, i - start);
                start = indexes[index] + 1;
            }
            indexes[index] = i;
        }

        result = Math.max(s.length() - start, result);
        return result;
    }
}
