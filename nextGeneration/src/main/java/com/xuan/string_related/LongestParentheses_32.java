package com.xuan.string_related;

/**
 * Created by xzhou2 on 6/27/16.
 */
public class LongestParentheses_32 {
    public int longestValidParentheses(String s) {
        s = ')' + s;
        int[] cache = new int[s.length()];
        int result = 0;
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1 - cache[i - 1]) == '(') {
                cache[i] = 2 + cache[i-1] + cache[i - 2 - cache[i-1]];
                result = Math.max(cache[i], result);
            }
        }
        return result;
    }
}
