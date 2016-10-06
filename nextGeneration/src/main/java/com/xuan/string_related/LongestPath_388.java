package com.xuan.string_related;

import java.util.Stack;

/**
 * Created by xzhou2 on 10/5/16.
 */
public class LongestPath_388 {
    public int lengthLongestPath(String input) {
        int result = 0, start = 0;
        boolean isFile = false;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '.') {
                isFile = true;
            }
            if (c == '\n') {
                int len = i - start + (stack.isEmpty() ? 0 : stack.peek()), depth = 0;
                if (isFile) {
                    result = Math.max(result , len);
                } else {
                    stack.push(len + 1);
                }
                i++;
                while(i < input.length() && input.charAt(i) == '\t') {
                    i++;
                    depth++;
                }
                while(depth < stack.size()) {
                    stack.pop();
                }
                start = i;
                i--;
                isFile = false;
            }
        }
        if (isFile) {
            result = Math.max(result,input.length() - start + (stack.isEmpty() ? 0 : stack.peek()));
        }
        return result;
    }
}
