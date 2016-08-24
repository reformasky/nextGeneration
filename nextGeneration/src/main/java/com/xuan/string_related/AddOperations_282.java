package com.xuan.string_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 8/17/16.
 */
public class AddOperations_282 {
    boolean log = true;
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        dfs(num.toCharArray(), 0, target, 0, 1, true, new StringBuilder(), result);
        return result;
    }

    private void dfs(char[] num, int index, long target, long curr, long left, boolean sign, StringBuilder sb, List<String> result) {
        sb.append(num[index]);
        curr = curr * 10 + num[index] - '0';
        long val = sign ? left * curr: - left * curr;

        if (index == num.length - 1) {
            if (target == val) {
                result.add(sb.toString());
            }
        } else {
            sb.append('+');
            dfs(num, index+1, target - val, 0, 1, true, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            sb.append('-');
            dfs(num, index+1, target - val, 0, 1, false, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            sb.append('*');
            dfs(num, index+1, target, 0, left * curr, sign, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            if (curr != 0  ) {
                dfs(num, index+1, target, curr, left, sign, sb, result);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }

}
