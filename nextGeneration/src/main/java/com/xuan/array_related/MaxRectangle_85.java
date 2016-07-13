package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/9/16.
 */
public class MaxRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        int[] heights = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                heights[j] = (matrix[i][j] != '0' ? (heights[j] +1) : 0);
            }
            result = Math.max(result, maxArea(heights));
        }
        return result;
    }


    private int maxArea(int[] heights) {
        int[] stack = new int[heights.length + 1];
        int curr = -1;
        int result = 0;
        for(int i = 0; i <= heights.length; i++) {
            int h = i < heights.length ? heights[i] : -1;
            while(curr >= 0 && h < heights[stack[curr]]) {
                int index = stack[curr--];
                int w = (curr < 0 ? i : (i - stack[curr] - 1));
                result = Math.max(result, heights[index] * w);
            }
            stack[++curr] = i;
        }
        return result;
    }
}
