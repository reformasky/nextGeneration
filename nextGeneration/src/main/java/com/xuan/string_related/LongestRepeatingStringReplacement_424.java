package com.xuan.string_related;

/**
 * Created by xzhou2 on 10/18/16.
 */
public class LongestRepeatingStringReplacement_424 {
    public int characterReplacement(String s, int k) {
        if (k >= s.length()) {
            return s.length();
        }
        int res = k;
        int[] counts = new int[26];
        int low = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.length() - low<= res) {
                break;
            }
            counts[s.charAt(i) - 'A']++;
            if (i - low  >= k) {
                if (isValid(counts, i - low + 1 - k)) {
                    res = Math.max(res, i - low + 1);
                } else {
                    counts[s.charAt(low++) - 'A']--;
                }
            }
        }
        return res;
    }

    private boolean isValid(int[] counts, int c) {
        for(int i : counts) {
            if (i >= c) {
                return true;
            }
        }
        return false;
    }
}
