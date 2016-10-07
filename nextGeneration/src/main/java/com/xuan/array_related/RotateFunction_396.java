package com.xuan.array_related;

/**
 * Created by xzhou2 on 10/6/16.
 */
public class RotateFunction_396 {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int sum = 0, result = 0, pre;
        for(int i = 0; i < A.length; i++) {
            result += i * A[i];
            sum += A[i];
        }
        pre = result;
        for(int i = A.length - 1; i > 0; i--) {
            int curr = pre - 2 * A[i] + sum;
            result = Math.max(curr, result);
            pre = curr;
        }
        return result;
    }
}
