package com.xuan.string_related;

/**
 * Created by xzhou2 on 8/11/16.
 */
public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
