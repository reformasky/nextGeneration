package com.xuan.string_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 10/4/16.
 */
public class IndexOfFirstUnique_387 {
    public int firstUniqChar(String s) {
        int result = s.length();
        int[] cache = new int[26];
        Arrays.fill(cache, -2);
        for(int i = 0; i < s.length(); i ++) {
            int c = s.charAt(i) - 'a';
            if (cache[c] == -2) {
                cache[c] = i;
            } else {
                cache[c] = -1;
            }
        }
        for(int i : cache) {
            if (i >= 0) {
                result = Math.min(result, i);
            }
        }
        return result == s.length() ? -1 : result;
    }
}
