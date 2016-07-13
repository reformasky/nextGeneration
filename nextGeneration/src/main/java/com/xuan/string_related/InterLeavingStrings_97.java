package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/11/16.
 */
public class InterLeavingStrings_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[] cache = new boolean[s2.length() + 1];
        cache[0] = true;
        for(int i = 0; i < s2.length(); i++) {
            cache[i+1] = (cache[i] && s2.charAt(i) == s3.charAt(i));
        }
        for(int i = 0; i < s1.length(); i++) {
            cache[0] = cache[0] && s1.charAt(i) == s3.charAt(i);
            for(int j = 0; j < s2.length(); j++) {
                cache[j+1] = (cache[j] && s2.charAt(j) == s3.charAt(i + j + 1)) ||
                        (cache[j+1] && s1.charAt(i) == s3.charAt(i + j + 1));
            }
        }
        return cache[s2.length()];
    }
}
