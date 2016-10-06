package com.xuan.string_related;

/**
 * Created by xzhou2 on 9/28/16.
 */
public class RansomNote_383 {
    public boolean canConstruct(String r, String m) {
        int[] cache = new int[26];
        for(int i = 0; i < m.length(); i++) {
            cache[m.charAt(i) - 'a']++;
        }
        for(int i = 0; i < r.length(); i++) {
            if (--cache[r.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
