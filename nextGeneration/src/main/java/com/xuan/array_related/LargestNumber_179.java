package com.xuan.array_related;

import java.util.Arrays;

/**
 * Created by xzhou2 on 7/28/16.
 */
public class LargestNumber_179 {
    public String largestNumber(int[] nums) {
        nums = Arrays.stream(nums).boxed().sorted((p, q) -> compare(String.valueOf(p), String.valueOf(q))).mapToInt(i->i).toArray();
        StringBuilder sb = new StringBuilder();
        if(nums[0] == 0) {
            sb.append(0);
            return sb.toString();
        }
        for(int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private int compare(String s1, String s2) {
        return compare(s1.toCharArray(), 0, s2.toCharArray(), 0);
    }

    private int compare(char[] s1, int index1, char[] s2, int index2) {
        for(;index1 < s1.length && index2 < s2.length; index1++, index2++) {
            if (s1[index1] < s2[index2]) {
                return 1;
            } else if (s1[index1] > s2[index2]) {
                return -1;
            }
        }
        if (index1 == s1.length && index2 == s2.length) {
            return 0;
        } else if (index1 != s1.length) {
            return compare(s1, index1, s2, 0);
        } else {
            return compare(s1, 0, s2, index2);
        }
    }
}
