package com.xuan.string_related;

/**
 * Created by xzhou2 on 7/4/16.
 */
public class AddBinary_67 {
    public String addBinary(String a, String b) {
        StringBuilder reverse = new StringBuilder(Math.max(a.length(), b.length()) + 1);
        int end = Math.min(a.length(), b.length());
        int carryOver = 0, curr;
        for(int i = 0; i < end; i++) {
            int ai = a.charAt(a.length() - 1 - i) - '0';
            int bi = b.charAt(b.length() - 1 - i) - '0';
            curr = ai + bi + carryOver;
            reverse.append(curr % 2);
            carryOver = curr / 2;
        }
        String leftOver = a;
        if (a.length() < b.length()) {
            leftOver = b;
        }
        for(int i = end; i < leftOver.length(); i++) {
            int li = leftOver.charAt(leftOver.length() - i - 1) - '0';
            curr = li + carryOver;
            reverse.append(curr % 2);
            carryOver = curr / 2;
        }
        if (carryOver != 0 || reverse.length() == 0) {
            reverse.append(carryOver);
        }

        return reverse.reverse().toString();
    }
}
