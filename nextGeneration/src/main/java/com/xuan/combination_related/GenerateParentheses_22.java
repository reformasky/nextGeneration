package com.xuan.combination_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 6/24/16.
 */
public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0, 0, 0, n, new char[n * 2], result);
        return result;
    }

    private void helper(int index, int open,int closed, int target, char[] path, List<String> result) {
        if (index >= target * 2) {
            result.add(new String(path));
            return;
        }
        if (open >= target - closed) {
            path[index] = ')';
            helper(index+1, open-1, closed+1, target, path, result);
        }
        else if (open > 0) {
            path[index] = '(';
            helper(index+1, open+1, closed, target, path, result);
            path[index] = ')';
            helper(index+1, open-1, closed+1, target, path, result);
        }
        else {
            path[index] = '(';
            helper(index+1, open+1, closed, target, path, result);
        }
    }
}
