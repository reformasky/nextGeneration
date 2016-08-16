package com.xuan.string_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 8/12/16.
 */
public class DifferentWaysToAddParentheses_241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return new ArrayList<Integer>();
        }
        int num = 0;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                operators.add(c);
                operands.add(num);
                num = 0;
            }
        }
        operands.add(num);
        int len = operands.size();
        List<Integer>[][] cache = (List<Integer>[][]) new List[len][len];

        for(int i = 0; i < len; i++) {
            cache[i][i] = Arrays.asList(operands.get(i));
        }
        for(int diff = 1; diff < len; diff++) {
            for(int i = 0; i < len - diff; i++) {
                int j = i + diff;
                cache[i][j] = new ArrayList<>();
                for(int k = i; k < j; k++) {
                    char operator = operators.get(k);
                    for(Integer op1 : cache[i][k]) {
                        for(Integer op2 : cache[k+1][j]) {
                            cache[i][j].add(calculate(op1, op2, operator));
                        }
                    }
                }
            }
        }
        return cache[0][len - 1];

    }

    private int calculate(int op1, int op2, char operator) {
        switch(operator) {
            case '+': return op1 + op2;
            case '-': return op1 - op2;
            case '*': return op1 * op2;
            default:
                throw new RuntimeException();
        }
    }
}
