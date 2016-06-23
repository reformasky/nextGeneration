package com.xuan.string_related;

/**
 * Created by xzhou2 on 6/20/16.
 */
public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int segmentSize = 2 * numRows - 2;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            int index1 = i, index2 = segmentSize - i;
            while(index1 < s.length() && index2 < s.length()) {
                sb.append(s.charAt(index1));
                if (i > 0 && i < numRows - 1) {
                    sb.append(s.charAt(index2));
                }
                index1 += segmentSize;
                index2 += segmentSize;
            }
            if (index1 < s.length()) {
                sb.append(s.charAt(index1));
            }
        }
        return sb.toString();
    }
}
