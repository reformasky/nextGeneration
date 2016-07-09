package com.xuan.array_related;

import java.util.Stack;

/**
 * Created by xzhou2 on 7/8/16.
 */
public class MaxAreaHisgram_84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int[] temp = heights;
        heights = new int[heights.length + 1];
        for(int i = 0; i < temp.length; i++) {
            heights[i] = temp[i];
        }
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
            }
            else {
                int index = stack.pop();
                int w = (stack.isEmpty()) ? i : (i - stack.peek() - 1);
                area = Math.max(area, heights[index] * w);
                i--;
            }
        }
        return area;
    }
}
