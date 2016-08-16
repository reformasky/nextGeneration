package com.xuan.array_related;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xzhou2 on 8/15/16.
 */
public class SlideWindowMax_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>(k);
        for(int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.getFirst() < (i - k + 1)) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                result[index++] = nums[deque.getFirst()];
            }
        }
        return result;
    }
}
