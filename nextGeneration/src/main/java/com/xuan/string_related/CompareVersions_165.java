package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/27/16.
 */
public class CompareVersions_165 {
    public int compareVersion(String version1, String version2) {
        int index1 = 0, index2 = 0, tmp1, tmp2, v1, v2;
        while(index1 < version1.length() && index2 < version2.length()) {
            tmp1 = version1.indexOf('.', index1);
            tmp2 = version2.indexOf('.', index2);
            if (tmp1 < 0) {
                v1 = Integer.parseInt(version1.substring(index1));
                index1 = version1.length();
            } else {
                v1 = Integer.parseInt(version1.substring(index1, tmp1));
                index1 = tmp1 + 1;
            }
            if (tmp2 < 0) {
                v2 = Integer.parseInt(version2.substring(index2));
                index2 = version2.length();
            } else {
                v2 = Integer.parseInt(version2.substring(index2, tmp2));
                index2 = tmp2 + 1;
            }
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        if (index1 >= version1.length() || !containsNoZeros(version1, index1)) {
            return (index2 >= version2.length()|| !containsNoZeros(version2, index2) )? 0 : -1;
        }
        return 1;
    }


    private boolean containsNoZeros(String s, int index) {
        for(int i = index; i < s.length();i++) {
            char c = s.charAt(i);
            if (c == '.' || c == '0') {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }
}
