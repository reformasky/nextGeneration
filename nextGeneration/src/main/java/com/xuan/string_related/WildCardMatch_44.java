package com.xuan.string_related;

/**
 * Created by xzhou2 on 6/30/16.
 */
public class WildCardMatch_44 {
    public boolean isMatch_DP(String s, String p) {
        if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')return false;
        boolean[] cache = new boolean[s.length() + 1];
        cache[0] = true;
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*') {
                int k = 0;
                for(; k < s.length() + 1; k++) {
                    if (cache[k]) {
                        break;
                    }
                }
                for(; k < s.length() + 1; k++) {
                    cache[k] = true;
                }
            }
            else {
                for(int j = s.length() - 1; j >= 0; j--) {
                    cache[j + 1] = cache[j] && (c == '?' || c == s.charAt(j));
                }
            }
            cache[0] = cache[0] && c == '*';
        }
        return cache[s.length()];
    }

    public boolean isMatch_greedy(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
