package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/26/16.
 */
public class ReverseWordsInString_151 {
    public String reverseWords(String s) {
        int index = s.length() - 1,end = index + 1;
        StringBuilder sb = new StringBuilder(s.length());
        while(index >= 0) {
            char c = s.charAt(index);
            if (c == ' ') {
                if (end > index + 1) {
                    sb.append(' ' + s.substring(index + 1, end));
                }
                end = index;
            }
            index--;
        }

        if (end > index + 1) {
            sb.append(' ' + s.substring(index + 1, end));
        }
        if (sb.length() > 0) {
            return sb.toString().substring(1);
        } else {
            return "";
        }
    }
}
