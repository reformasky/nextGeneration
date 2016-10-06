package com.xuan.TreeRelated;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by xzhou2 on 9/6/16.
 */
public class VerifyPreorderSerialization_331 {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(preorder.split(",")));
        return isValid(queue) && queue.isEmpty();
    }

    private boolean isValid(Queue<String> queue) {
        if (queue.isEmpty()) {
            return false;
        }
        String curr = queue.poll();
        if (curr.equals("#")) {
            return true;
        } else {
            return isValid(queue) && isValid(queue);
        }
    }
}
