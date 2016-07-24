package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/22/16.
 */
public class Candy_135 {
    public int candy(int[] ratings) {
        int result = 0;
        int high = 0;
        int curr = 1;
        int highRating = 0;
        for(int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                result += curr;
            }
            else {
                if (ratings[i] >= ratings[i - 1]) {
                    high = i;
                    curr = ratings[i] == ratings[i-1] ? 1 : (curr + 1);
                    result += curr;
                    highRating = curr;
                }
                else {
                    result += (i - high);
                    if (i - high >= highRating) {
                        result++;
                    }
                    curr = 1;
                }
            }
        }
        return result;
    }
}
