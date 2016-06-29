package com.xuan.string_related;

/**
 * Created by xzhou2 on 6/26/16.
 */
public class StrStr_28 {
    public int strStr(String haystack, String needle) {
        int index = 0;
        for(; index <= haystack.length() - needle.length();index++) {
            int j = 0;
            for(; j < needle.length();j++) {
                if (haystack.charAt(index + j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == needle.length()) {
                return index;
            }
        }
        return -1;
    }
}
