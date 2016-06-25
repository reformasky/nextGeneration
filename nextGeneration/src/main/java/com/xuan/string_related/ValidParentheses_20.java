package com.xuan.string_related;

import java.util.Stack;

/**
 * Created by xzhou2 on 6/24/16.
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':;
                case '[':;
                case '{': stack.push(c); break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
