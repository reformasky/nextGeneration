package com.xuan.other;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xzhou2 on 8/7/16.
 */
public class MyStack {
    Queue<Integer> queue1, queue2;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        prepare();
        queue1.poll();
    }

    // Get the top element.
    public int top() {
        prepare();
        return queue1.peek();
    }

    private void prepare() {
        if (queue1.isEmpty()) {
            Queue<Integer> tmp = queue2;
            queue2 = queue1;
            queue1 = tmp;
        }
        while(queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}