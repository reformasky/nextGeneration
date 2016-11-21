package com.xuan.string_related;

/**
 * Created by xzhou2 on 10/6/16.
 */
public class LongestSubstring_295 {
    public int longestSubstring(String s, int k) {
        if (k <= 1) {
            return s.length();
        }
        return helper(s.toCharArray(), 0, s.length() - 1, k);
    }

    private int helper(char[] arr, int begin, int end, int k) {
        if (begin > end) {
            return 0;
        }
        int[] counts = new int[26];
        boolean[] valid = new boolean[26];
        int missing = 0;
        for(int i = begin; i <= end; i++) {
            counts[arr[i] - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if (counts[i] == 0 || counts[i] >= k) {
                valid[i] = true;
            } else {
                missing++;
            }
        }
        if(missing == 0) {
            return end - begin + 1;
        } else if (missing == 26){
            return 0;
        }else {
            int result = 0;
            int b = begin;
            for(int i = begin; i <= end; i++) {
                if (!valid[arr[i] - 'a']) {
                    result = Math.max(helper(arr,b, i - 1, k), result);
                    b = i + 1;
                }
            }
            result = Math.max(helper(arr, b, end, k), result);
            return result;
        }
    }
}
