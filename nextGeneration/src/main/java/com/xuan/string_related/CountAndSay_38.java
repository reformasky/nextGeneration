package com.xuan.string_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 6/28/16.
 */
public class CountAndSay_38 {
    private static final List<String> cache;
    static {
        cache = new ArrayList<>();
        cache.add("1");
    }
    public String countAndSay(int n) {
        if (n <= 0) {
            return "1";
        }
        if (cache.size() >= n) {
            return cache.get(n-1);
        }
        String pre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char curr = pre.charAt(0);
        int count = 1;
        for(int i = 1; i < pre.length();i++) {
            char c = pre.charAt(i);
            if (c != curr) {
                sb.append(count+""+curr);
                curr = c;
                count = 0;
            }
            count++;
        }
        sb.append(count+""+curr);
        String result = sb.toString();
        cache.add(result);
        return result;
    }
}
