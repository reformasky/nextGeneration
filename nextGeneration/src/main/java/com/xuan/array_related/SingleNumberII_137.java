package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/22/16.
 */
public class SingleNumberII_137 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for(int num : nums) {
            int mask = 1;
            for(int i = 0; i < 32; i++) {
                count[i] += (mask & num);
                num >>= 1;
            }
        }

        int result = 0, mask = 1;
        for(int i = 0; i < 32; i++) {
            if (count[i] % 3 != 0) {
                result |= mask;
            }
            mask <<= 1;
        }
        return result;
    }
}
