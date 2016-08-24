package com.xuan.string_related;

/**
 * Created by xzhou2 on 8/22/16.
 */
public class BullsAndCows_299 {
    public String getHint(String secret, String guess) {
        if(secret.length() == 0) {
            return "0A0B";
        }
        int[] countS = new int[10];
        int countA = 0, diff = 0;
        for(int i = 0; i < secret.length(); i++) {
            char cS = secret.charAt(i), cG = guess.charAt(i);
            if(cS == cG) {
                countA++;
            }
            countS[cS - '0']++;
            countS[cG - '0']--;
        }
        for(int i = 0; i < 10; i++) {
            if (countS[i] > 0) {
                diff+=countS[i];
            } else {
                diff -=countS[i];
            }
        }
        return countA+"A" + (secret.length() *2- 2 * countA - diff) /2 + "B";
    }
}
