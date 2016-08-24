package com.xuan.array_related;

/**
 * Created by xzhou2 on 8/18/16.
 */
public class GameOfLives_289 {
    static final int[][] directions;
    static {
        directions = new int[][]{
                new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1},
                new int[]{0, -1}, new int[]{0, 1},
                new int[]{1, -1}, new int[]{1, 0}, new int[]{1, 1}
        };
    }

    //0->1:2; 1->0:3 %2 || reverse %3 == 0

    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) {
            return;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int l = getLives(board, i, j);
                int curr = board[i][j];
                if (curr == 1 && (l < 2 || l >3)) {
                    board[i][j] = 3;
                }
                if (curr == 0 && l ==3) {
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] % 3 == 0 ? 0 : 1;
            }
        }
    }

    private int getLives(int[][] board, int i, int j) {
        int result = 0;
        for(int[] d : directions) {
            if (i + d[0] >= 0 && i + d[0] < board.length
                    && j + d[1] >= 0 && j + d[1] < board[0].length
                    && (board[i + d[0]][j + d[1]]) % 2 == 1) {
                result++;
            }
        }
        return result;
    }
}
