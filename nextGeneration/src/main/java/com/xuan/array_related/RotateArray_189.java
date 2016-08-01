package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/29/16.
 */
public class RotateArray_189 {
    public void rotate_1(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (k == 0) {
            return;
        }
        int g = gcd(k, len);
        for(int i = 0; i < g; i++) {
            int curr = i, val = nums[i], tmp, n;
            do {
                n = next(curr, k, len);
                tmp = nums[n];
                nums[n] = val;
                val = tmp;
                curr = n;
            } while( curr != i);
        }
    }

    int gcd(int x, int y) {
        while(y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    int next(int x, int k, int len) {
        return (x + k) % len;
    }


    public void rotate_2(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (k ==0) {
            return;
        }
        int[] tmp = new int[k];
        for(int i = 0; i < k; i++) {
            tmp[i] = nums[i + len - k];
        }
        for(int i = len - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for(int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }
}
