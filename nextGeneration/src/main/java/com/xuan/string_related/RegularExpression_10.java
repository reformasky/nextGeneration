package com.xuan.string_related;

/**
 * Created by xzhou2 on 6/21/16.
 */
public class RegularExpression_10 {
    public boolean isMatch(String s, String p) {
        if (s == null) {
            return p == null;
        }
        return helper(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean helper(char[] s, int index1, char[] p, int index2) {
        if (index2 >= p.length) {
            return index1 >= s.length;
        }
        if (index2 == p.length - 1) {
            return index1 == s.length - 1 && (s[index1] == p[index2] || p[index2] == '.');
        }

        char next = p[index2 + 1];
        if (next != '*') {
            if (matches(s, index1, p, index2)) {
                return helper(s, index1 + 1, p, index2 + 1);
            }
            else {
                return false;
            }
        }
        else {
             if (matches(s, index1, p, index2)) {
                return helper(s, index1 + 1, p, index2) || helper(s, index1, p, index2 + 2);
            }
            else {
                return helper(s, index1, p, index2 + 2);
            }
        }
    }

    private boolean matches(char[] s, int index1, char[] p, int index2) {
        return index1 < s.length && (s[index1] == p[index2] || p[index2] == '.');
    }

    public boolean isMatch_dp(String s, String p) {
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }
        if (p.charAt(0) == '*') {
            return false;
        }

        boolean[][] cache = new boolean[s.length() + 1][p.length() + 1];
        cache[0][0] = true;
        for(int j = 0; j < p.length();j++) {
            if (p.charAt(j) == '*') {
                cache[0][j+1] = cache[0][j-1];
            }
        }
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < p.length(); j++) {
                char cs = s.charAt(i), cp = p.charAt(j);
                if (cp != '*') {
                    if (cs == cp || cp == '.') {
                        cache[i+1][j+1] = cache[i][j];
                    }
                }
                else {
                    if (p.charAt(j - 1) == cs || p.charAt(j-1) == '.') {
                        cache[i+1][j+1] = cache[i+1][j] || cache[i + 1][j -1] || cache[i][j+1];
                    }
                    else {
                        cache[i+1][j+1] = cache[i+1][j-1];
                    }
                }
            }
        }
        return cache[s.length()][p.length()];
    }
}
