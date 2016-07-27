package com.xuan.other;

import java.util.Stack;

/**
 * Created by xzhou2 on 7/26/16.
 */
public class MinStack {
    Stack<Integer> min, curr;
    /** initialize your data structure here. */
    public MinStack() {
        min = new Stack<>();
        curr = new Stack<>();
    }

    public void push(int x) {
        int m = isEmpty() ? x : min.peek();
        curr.push(x);
        min.push(Math.min(m, x));
    }

    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        min.pop();
        curr.pop();
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return curr.peek();
    }

    public int getMin() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return min.peek();
    }

    private boolean isEmpty() {
        return curr.isEmpty();
    }
}
