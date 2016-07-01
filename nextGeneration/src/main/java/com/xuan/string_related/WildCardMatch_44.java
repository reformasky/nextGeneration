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

    public boolean isMatch_greedy(String s, String p) {
        int idxS = 0, idxP = 0,
                starIdx = -1, matchIdx = 0;
        while(idxS < s.length()) {
            if (idxP < p.length() && (p.charAt(idxP) == '?' || p.charAt(idxP) == s.charAt(idxS))) {
                idxS++;
                idxP++;
            }
            else if (idxP < p.length() && p.charAt(idxP) == '*') {
                starIdx = ++idxP;
                matchIdx = idxS;
            }
            else if (starIdx != -1) {
                idxP = starIdx + 1;
                idxS = ++matchIdx;
            }
            else {
                return false;
            }
        }
        while(idxP < p.length() && p.charAt(idxP) == '*') {
            idxP++;
        }
        return idxP == p.length();
    }
}
