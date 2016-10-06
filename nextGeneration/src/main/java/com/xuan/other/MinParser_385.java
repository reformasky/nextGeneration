package com.xuan.other;



import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 10/3/16.
 */
public class MinParser_385 {
    public com.xuan.util.NestedInteger deserialize(String s) {
        NestedInteger result = new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(result);
        boolean hasInt = false;
        int val = 0, sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                NestedInteger curr = new NestedInteger();
                stack.push(curr);
            } else if (c == ']') {
                NestedInteger curr = stack.pop();
                if (hasInt) {
                    curr.add(new NestedInteger(sign * val));
                }
                stack.peek().add(curr);
                val = 0;
                sign = 1;
                hasInt = false;
            } else if (c == ','){
                if (hasInt) {
                    stack.peek().add(new NestedInteger(sign * val));
                }
                val = 0;
                sign = 1;
                hasInt = false;
            } else if (c == '-'){
                sign = -1;
            } else {
                val = val * 10 + c - '0';
                hasInt = true;
            }
        }
        if (hasInt) {
            stack.peek().add(new NestedInteger(sign * val));
        }
        return result.getList().isEmpty() ? new NestedInteger() : result.getList().get(0);
    }
}

class NestedInteger implements com.xuan.util.NestedInteger{
    public NestedInteger(){

    }
    public NestedInteger(int i) {

    }
    public void add(NestedInteger n) {

    }
    public void setInteger(int i) {

    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public List<com.xuan.util.NestedInteger> getList() {
        return null;
    }
}
