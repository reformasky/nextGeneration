package com.xuan.array_related;

import java.util.Stack;

/**
 * Created by xzhou2 on 7/25/16.
 */
public class ReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if (token.length() > 1 || (token.charAt(0) >= '0' && token.charAt(0) <= '9')) {
                stack.push(Integer.parseInt(token));
            } else {
                int t2 = stack.pop(), t1 = stack.pop(), result = 0;
                char c = token.charAt(0);
                switch(c) {
                    case '+': result = t1 + t2; break;
                    case '-': result = t1 - t2; break;
                    case '*': result = t1 * t2; break;
                    case '/': result = t1 / t2; break;
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }
}
