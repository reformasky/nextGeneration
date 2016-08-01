package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/27/16.
 */
public class ConvertToTitle_168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int r = n % 26;
            char c = (r == 0) ? 'Z' : (char)(r -1 + 'A');
            sb.append(c);
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
