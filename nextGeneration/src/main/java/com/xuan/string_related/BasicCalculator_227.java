package com.xuan.string_related;

import java.util.Stack;

/**
 * Created by xzhou2 on 8/8/16.
 */
public class BasicCalculator_227 {
    public int calculate_efficient(String s) {
        int res = 0, left = 0, sign = 1, op = 0;
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = 10 * num + c - '0';
            } else{
                if (op == 1) {
                    num = left * num;
                }
                if (op == -1) {
                    num = left / num;
                }
                op = 0;
                if (c == '+' || c == '-') {
                    res += sign * num;
                    sign = c == '+' ? 1 : -1;

                } else if (c == '*' || c == '/') {
                    left = num;
                    op = c == '*' ? 1 : -1;
                }
                num = 0;
            }
        }
        if (op == 0) {
            res += sign * num;
        } else if (op == 1) {
            res += sign * left * num;
        } else {
            res += sign * left / num;
        }
        return res;
    }




    public int calculate(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        int num = 0;
        for(int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '+' || c == '-') {
                intStack.push(num);
                while (! charStack.isEmpty()) {
                    int op2 = intStack.pop();
                    int op1 = intStack.pop();
                    intStack.push(calculate(op1, op2, charStack.pop()));
                }
                num = 0;
                charStack.push(c);
            } else if (c == '*' || c == '/') {
                intStack.push(num);
                if (!charStack.isEmpty() && (charStack.peek() == '*' || charStack.peek() == '/')) {
                    int op2 = intStack.pop();
                    int op1 = intStack.pop();
                    intStack.push(calculate(op1, op2, charStack.pop()));
                }
                num = 0;
                charStack.push(c);
            }
        }
        intStack.push(num);
        while(!charStack.isEmpty()) {
            int op2 = intStack.pop();
            int op1 = intStack.pop();
            intStack.push(calculate(op1, op2, charStack.pop()));
        }
        return intStack.pop();
    }

    private int calculate(int op1, int op2, char operator) {
        switch(operator) {
            case '+' : return op1 + op2;
            case '-' : return op1 - op2;
            case '*' : return op1 * op2;
            case '/' : return op1 / op2;
            default:
                throw new RuntimeException();
        }
    }
}
