package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xzhou2 on 10/19/16.
 */
public class TrappingRainWater_407 {
    int result = 0;
    int nRow, nCol;
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return result;
        }
        nRow = heightMap.length;
        nCol = heightMap[0].length;
        boolean[][] visited = new boolean[nRow][nCol];
        PriorityQueue<Cell> queue = new PriorityQueue<>();
        for(int i = 0; i < nCol; i++) {
            queue.add(new Cell(0, i, heightMap[0][i]));
            queue.add(new Cell(nRow - 1, i, heightMap[nRow - 1][i]));
            visited[0][i] = true;
            visited[nRow - 1][i] = true;
        }
        for(int i = 1; i < nRow - 1; i++) {
            queue.add(new Cell(i, 0, heightMap[i][0]));
            queue.add(new Cell(i, nCol - 1, heightMap[i][nCol - 1]));
            visited[i][0] = true;
            visited[i][nCol - 1] = true;
        }
        while(!queue.isEmpty()) {
            Cell curr = queue.poll();
            for(Cell c : next(curr, heightMap)) {
                dfs(c, curr, heightMap, visited, queue);
            }
        }
        return result;
    }

    private void dfs(Cell curr, Cell pre, int[][] heightMap, boolean[][] visited, Queue<Cell> queue) {
        if (!visited[curr.r][curr.c]) {
            visited[curr.r][curr.c] = true;
            if (curr.h < pre.h) {
                result += (pre.h - curr.h);
                for(Cell c : next(curr, heightMap)) {
                    dfs(c, pre, heightMap, visited, queue);
                }
            } else {
                queue.add(curr);

            }

        }
    }

    public List<Cell> next(Cell curr, int[][] heightMap) {
        int[][] diffs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Cell> result = new ArrayList<>(4);
        for(int[] diff : diffs) {
            int row = curr.r + diff[0], col = curr.c + diff[1];
            if (row >= 0 && row < nRow && col >= 0 && col < nCol) {
                result.add(new Cell(row, col, heightMap[row][col]));
            }
        }
        return result;
    }


    class Cell implements Comparable<Cell>{
        int r, c, h;
        public Cell(int row, int col, int height) {
            r = row;
            c = col;
            h = height;
        }
        @Override
        public int compareTo(Cell that) {
            return h - that.h;
        }
    }


}
