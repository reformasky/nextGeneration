package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/22/16.
 */
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int index = 0;
        while(index < strs[0].length()) {
            Character curr = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || curr != strs[i].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }
}
