package com.xuan.other;

import java.util.Iterator;

/**
 * Created by xzhou2 on 8/18/16.
 */
class PeekingIterator implements Iterator<Integer> {
    Integer holder;
    Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        holder = null;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (holder == null) {
            holder = iterator.next();
        }
        return holder;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res;
        if (holder != null) {
            res = holder;
            holder = null;
        } else {
            res = iterator.next();
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return holder != null || iterator.hasNext();
    }
}