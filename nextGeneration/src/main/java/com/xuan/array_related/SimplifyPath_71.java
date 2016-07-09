package com.xuan.array_related;

import java.util.Stack;

/**
 * Created by xzhou2 on 7/5/16.
 */
public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        path = path + "/";
        Stack<String> stack = new Stack<>();
        int start = 0;
        String curr;
        for(int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (i > start) {
                    curr = path.substring(start, i);
                    if (curr.equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                    else if (curr.equals(".")) {
                    }
                    else {
                        stack.push(curr);
                    }
                }
                start = i + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        if (sb.length() == 0 ) {
            sb.append("/");
        }
        return sb.toString();
    }
}
