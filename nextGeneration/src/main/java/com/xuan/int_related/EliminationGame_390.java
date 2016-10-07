package com.xuan.int_related;

/**
 * Created by xzhou2 on 10/5/16.
 */
public class EliminationGame_390 {
 /*   public int lastRemaining(int n) {
        int left = 1, right = n;
        int diff = 2;
        boolean negative = false;
        while(left != right) {
            if (negative) {
                left += (right - left + diff / 2) % diff ;
                right -= diff / 2;
            } else {
                right -= (right - left + diff / 2) % diff ;
                left += diff / 2;
            }
            negative = !negative;
            diff *= 2;
        }
        return left;
    }*/

    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}
