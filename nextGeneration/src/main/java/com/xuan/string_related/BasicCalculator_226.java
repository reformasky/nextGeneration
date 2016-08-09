package com.xuan.string_related;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by xzhou2 on 8/7/16.
 */
public class BasicCalculator_226 {
    public int calculate_faster(String s) {
        int result = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                result += num * sign;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += num * sign;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')'){
                result += num * sign;
                result *= stack.pop();
                result += stack.pop();
                num = 0;
            }
        }
        result += sign * num;
        return result;
    }



    public int calculate(String s) {
        Deque<Common> commonStack = new ArrayDeque<>();
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                while(!charStack.isEmpty() && charStack.peek() != '(') {
                    commonStack.addLast(new Common(true, charStack.pop()));
                }
                charStack.push(c);
            } else if (c == '(') {
                charStack.push(c);
            } else if (c == ')') {
                while(charStack.peek() != '(') {
                    commonStack.addLast(new Common(true, charStack.pop()));
                }
                charStack.pop();
            } else if (c >= '0' && c <= '9'){
                int curr = 0;
                while(i < s.length() && (s.charAt(i) >= '0') && (s.charAt(i) <= '9')) {
                    curr = curr * 10 + (s.charAt(i) - '0');
                    i++;
                }
                commonStack.addLast(new Common(false, curr));
                i--;
            }
        }
        if (!charStack.isEmpty()) {
            commonStack.addLast(new Common(true, charStack.pop()));
        }

        while(!commonStack.isEmpty()) {
            Common c = commonStack.removeFirst();
            if (c.isOperator) {
                int v2 = intStack.pop();
                int v1 = intStack.pop();
                switch((char)c.val) {
                    case '+': intStack.push(v1 + v2);break;
                    case '-': intStack.push(v1 - v2);break;
                }
            } else {
                intStack.push(c.val);
            }
        }

        return intStack.isEmpty() ? 0 : intStack.pop();
    }

    class Common{
        boolean isOperator;
        int val;

        public Common(boolean isOp, int v) {
            isOperator = isOp;
            val = v;
        }
    }
}
