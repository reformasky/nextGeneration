package com.xuan.string_related;

import java.util.Stack;

/**
 * Created by xzhou2 on 10/6/16.
 */
public class DecodeString_394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> repeats = new Stack<>(),
                begins = new Stack<>();
        int value = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                value = value * 10 + c - '0';
            } else if (c == ']') {
                int begin = begins.pop();
                int repeat = repeats.pop();
                if (repeat > 0) {
                    String curr = sb.substring(begin);
                    while(repeat--> 0) {
                        sb.append(curr);
                    }
                }
            } else if (c == '[') {
                begins.push(sb.length());
                repeats.push(value - 1);
                value = 0;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
