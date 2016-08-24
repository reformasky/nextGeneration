package com.xuan.string_related;

/**
 * Created by xzhou2 on 8/23/16.
 */
public class IsAdditiveNumber_306 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for(int index1 = 0; index1 < num.length() / 2 + 1; index1++) {
            for(int index2 = index1 + 1; index2 < num.length() ; index2++) {
                if (isAdditiveNumber(num, 0, index1, index2)) {
                    return true;
                }
                if (num.charAt(index1 + 1) == '0') {
                    break;
                }
            }
            if (num.charAt(0) == '0') {
                break;
            }
        }

        return false;
    }

    private boolean isAdditiveNumber(String num, int start, int end1, int end2) {
        String sum = add(num, start, end1, end2);
        if (num.length() - end2 - 1 < sum.length()) {
            return false;
        }
        for(int i = 0; i < sum.length(); i++) {
            if (sum.charAt(i) != num.charAt(end2 + 1 + i)) {
                return false;
            }
        }
        return (sum.length() + end2 + 1 == num.length()) || isAdditiveNumber(num, end1 + 1, end2, end2 + sum.length());
    }

    private String add(String num, int start, int end1, int end2) {
        StringBuilder sb = new StringBuilder();
        int carryOver = 0;
        int index1 = end1, index2 = end2;
        while(index1>= start && index2 > end1) {
            int curr = carryOver + num.charAt(index1--) - '0' + num.charAt(index2--) - '0';
            sb.append(curr % 10);
            carryOver = curr / 10;
        }
        while(index1 >= start) {
            int curr = carryOver + num.charAt(index1--) - '0';
            sb.append(curr % 10);
            carryOver = curr / 10;
        }
        while(index2 > end1) {
            int curr = carryOver + num.charAt(index2--) - '0';
            sb.append(curr % 10);
            carryOver = curr / 10;
        }
        if (carryOver != 0) {
            sb.append(carryOver);
        }
        return sb.reverse().toString();
    }
}
