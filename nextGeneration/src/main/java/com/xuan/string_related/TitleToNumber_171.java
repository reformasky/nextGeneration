package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/27/16.
 */
public class TitleToNumber_171 {
    public int titleToNumber(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            result = result * 26 + s.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
