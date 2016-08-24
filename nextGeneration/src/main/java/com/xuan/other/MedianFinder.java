package com.xuan.other;

import java.util.PriorityQueue;

/**
 * Created by xzhou2 on 8/22/16.
 */
public class MedianFinder {
    PriorityQueue<Long> left = new PriorityQueue<>();
    PriorityQueue<Long> right = new PriorityQueue<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        right.offer((long)num);
        left.offer(-right.poll());
        if (left.size() > right.size()) {
            right.offer(-left.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (left.size() == right.size()) {
            return 0.5 * (right.peek() - left.peek());
        }
        else {
            return right.peek();
        }
    }
};
