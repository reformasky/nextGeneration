package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/4/16.
 */
public class IsNum_65 {
    public boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        int begin = 0, end = s.length();
        while(begin < end && s.charAt(begin) == ' ') {
            begin++;
        }
        while(end > begin && s.charAt(end - 1) == ' ') {
            end--;
        }
        if (begin < end && (s.charAt(begin) == '+' || s.charAt(begin) =='-')) {
            begin++;
        }
        boolean hasNum = false, hasDot = false;
        for(; begin < end; begin++){
            char c = s.charAt(begin);
            if (c>= '0' && c <='9') {
                hasNum = true;
            }
            else if (c == '.') {
                if (hasDot) {
                    return false;
                }
                hasDot = true;
            }
            else if (c == 'e') {
                return hasNum && (begin + 1 < end) && isInt(s.substring(begin + 1, end));
            }
            else {
                return false;
            }
        }
        return hasNum;
    }

    private boolean isInt(String s) {

        int begin = 0, end = s.length();
        if (s.charAt(begin) == '+' || s.charAt(begin) == '-') {
            begin++;
        }
        boolean hasNum = false;
        for(; begin < end; begin++) {
            char c = s.charAt(begin);
            if (c >= '0' && c <= '9') {
                hasNum = true;
            }
            else {
                return false;
            }
        }
        return hasNum;
    }
}
