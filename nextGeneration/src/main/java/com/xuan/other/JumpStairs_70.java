package com.xuan.other;

/**
 * Created by xzhou2 on 7/5/16.
 */
public class JumpStairs_70 {
    public int climbStairs(int n) {
        int pre = 1, curr = 1;
        int result = 1;
        for(int i = 1;  i < n; i++) {
            result = pre + curr;
            pre = curr;
            curr = result;
        }
        return result;
    }
}
