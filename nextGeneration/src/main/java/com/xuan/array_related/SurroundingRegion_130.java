package com.xuan.array_related;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xzhou2 on 7/19/16.
 */
public class SurroundingRegion_130 {
    public void solve_nonEfficient(char[][] board) {
        int nRow = board.length;
        if(nRow == 0){
            return;
        }
        int nCol = board[0].length;
        if (nCol == 0) {
            return;
        }
        boolean[][] keep = new boolean[nRow][nCol];
        Queue<Integer> r = new ArrayDeque<>(),
                c = new ArrayDeque<>();
        for(int i = 0; i < nCol; i++) {
            if (board[0][i] == 'O') {
                r.offer(0);
                c.offer(i);
            }
            if (board[nRow -1][i] == 'O') {
                r.offer(nRow -1);
                c.offer(i);
            }
        }
        for(int j = 1; j < nRow - 1; j++) {
            if (board[j][0] == 'O') {
                r.offer(j);
                c.offer(0);
            }
            if (board[j][nCol - 1] == 'O') {
                r.offer(j);
                c.offer(nCol - 1);
            }
        }
        while(!r.isEmpty()) {
            int i = r.poll(), j = c.poll();
            if (keep[i][j]) {
                continue;
            }
            keep[i][j] = true;
            if (i > 0  && board[i-1][j] == 'O') {
                r.offer(i-1);
                c.offer(j);
            }
            if (i < nRow - 1  && board[i+1][j] == 'O') {
                r.offer(i +1);
                c.offer(j);
            }
            if (j > 0  && board[i][j -1] == 'O') {
                r.offer(i);
                c.offer(j -1);
            }
            if (j < nCol -1  && board[i][j +1 ] == 'O') {
                r.offer(i);
                c.offer(j + 1);
            }
        }

        for(int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (!keep[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

}
