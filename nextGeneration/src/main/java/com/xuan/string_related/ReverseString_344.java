package com.xuan.string_related;

/**
 * Created by xzhou2 on 9/8/16.
 */
public class ReverseString_344 {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int low = 0, high = s.length() - 1;
        while(low < high) {
            char tmp = c[low];
            c[low++] = c[high];
            c[high--] = tmp;
        }
        return new String(c);
    }
}
