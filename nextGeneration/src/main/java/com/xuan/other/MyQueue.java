package com.xuan.other;

import java.util.Stack;

/**
 * Created by xzhou2 on 8/8/16.
 */
class MyQueue {
    Stack<Integer> stack1 = new Stack<>(),
            stack2 = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        prepare();
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        prepare();
        return stack2.peek();
    }

    private void prepare() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}