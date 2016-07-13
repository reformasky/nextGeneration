package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/9/16.
 */
public class ScrambleWords {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray(),
                c2 = s2.toCharArray();
        return isScramble(c1, 0, c1.length, c2, 0,c2.length);
    }

    private boolean isScramble(char[] c1, int low1, int high1, char[] c2, int low2, int high2) {
        if (low1 >= high1) {
            return true;
        }
        if (!isAnagram(c1, low1, high1, c2, low2, high2)) {
            return false;
        }
        if (low1 == high1 - 1) {
            return c1[low1] == c2[low2];
        }
        for(int i = low1 + 1; i < high1; i++) {
            if ((isScramble(c1, low1, i, c2, low2, low2 + i - low1) && isScramble(c1, i, high1, c2, low2 + i - low1, high2)) ||
                    (isScramble(c1, low1, i, c2, high2 - i + low1, high2) && isScramble(c1, i, high1, c2, low2, high2 - i+ low1))){
                return true;
            }
        }
        return false;
    }
    private boolean isAnagram(char[] c1, int low1, int high1, char[] c2, int low2, int high2) {
        char[] count = new char[128];
        for(int i = low1; i < high1; i++) {
            count[c1[i]]++;
        }
        for(int i = low2; i < high2; i++) {
            count[c2[i]]--;
        }
        for(int i = 0; i < 128; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
