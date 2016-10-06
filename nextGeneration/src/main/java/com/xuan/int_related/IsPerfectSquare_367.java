package com.xuan.int_related;

/**
 * Created by xzhou2 on 9/14/16.
 */
public class IsPerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        long begin = 1, end = num;
        long curr;
        while(begin <= end) {
            long mid = (begin + end ) / 2;
            curr = mid * mid;
            if (curr == num) {return true;}
            else if (curr > num) {end = mid - 1;}
            else {begin = mid + 1;}
        }
        return false;
    }
}
