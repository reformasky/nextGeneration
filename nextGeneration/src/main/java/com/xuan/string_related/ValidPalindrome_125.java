package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/18/16.
 */
public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() -1;
        while(l < r) {
            while(l < r && getVal(s.charAt(l)) < 0) {
                l++;
            }
            while(r > l && getVal(s.charAt(r)) < 0) {
                r--;
            }
            if (l == r) {
                return true;
            }
            if (getVal(s.charAt(l++)) != getVal(s.charAt(r--))) {
                return false;
            }
        }
        return true;
    }

    private int getVal(char c) {
        if (c >= '0' && c <= '9') {
            return c;
        }
        if (c >= 'a' && c <= 'z') {
            return c;
        }
        if (c >= 'A' && c <= 'Z') {
            return c + 'a' - 'A';
        }
        return -1;
    }
}
