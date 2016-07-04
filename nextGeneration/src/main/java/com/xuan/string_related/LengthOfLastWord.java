package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/2/16.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int result = 0;
        boolean start = false;
        for(int i = s.length() - 1; i >=0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (start) {
                    return result;
                }
            }
            else {
                start = true;
                result++;
            }
        }
        return result;
    }
}
