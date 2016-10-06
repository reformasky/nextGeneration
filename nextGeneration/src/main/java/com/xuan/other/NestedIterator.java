package com.xuan.other;

import com.xuan.util.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by xzhou2 on 9/8/16.
 */
public class NestedIterator implements Iterator<Integer> {
    Integer val;
    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        val = null;
        stack = new Stack<>();
        for(int i = nestedList.size() - 1;i >=0; i--) {
            stack.push(nestedList.get(i));
        }

    }

    @Override
    public Integer next() {
        Integer res = val;
        val = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        if (val != null) {
            return true;
        }
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.pop();
            if (curr.isInteger()) {
                val = curr.getInteger();
                return true;
            } else {
                List<NestedInteger> list = curr.getList();
                for(int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }

    //test case: [[1, [], [1,2], 3], 4, [[], 6,[7,[8, 9]]]]
}