package com.xuan.int_related;

/**
 * Created by xzhou2 on 6/20/16.
 */
public class PalindromeInteger_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int divisor = 1;
        int t = x / 10;
        while(divisor <= t) {
            divisor *= 10;
        }
        while(x > 0) {
            if (x % 10 != x / divisor) {
                return false;
            }
            x %= divisor;
            x /= 10;
            divisor /= 100;
        }
        return true;
    }

    public boolean isPalindrome_better(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}
