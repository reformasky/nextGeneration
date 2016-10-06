package com.xuan.array_related;

/**
 * Created by xzhou2 on 9/27/16.
 */
public class WiggleSequence_376 {
    public int wiggleMaxLength(int[] nums) {
        int lenUp = 0, lenDown = 0;
        int lastUp = Integer.MAX_VALUE, lastDown = Integer.MIN_VALUE;
        for(int n : nums) {
            int tmpLenUp = lenUp, tmpLenDown = lenDown, tmpLastUp = lastUp, tmpLastDown = lastDown;
            if(n > tmpLastDown) {
                lenUp = tmpLenDown + 1;
                lastUp = n;
            } else {
                lastUp = Math.max(tmpLastUp, n);
            }

            if (n < tmpLastUp) {
                lenDown = tmpLenUp + 1;
                lastDown = n;
            } else {
                lastDown = Math.min(tmpLastDown, n);
            }
        }

        return Math.max(lenUp, lenDown);
    }
}
