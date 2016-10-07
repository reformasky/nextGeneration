package com.xuan.string_related;

/**
 * Created by xzhou2 on 10/5/16.
 */
public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        int[] cache = new int[128];
        for(int i = 0; i < s.length(); i++) {
            cache[s.charAt(i)]++;
        }
        boolean hasOdd = false;
        int result = 0;
        for(int i : cache) {
            if (i % 2 == 0) {
                result += i;
            } else {
                result += (i - 1);
                hasOdd = true;
            }
        }
        return hasOdd ? result + 1 : result;
    }
}
