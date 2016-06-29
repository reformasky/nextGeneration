package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/28/16.
 */
public class SolveSudoku_37 {
    boolean[][] visited = new boolean[9][9];
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                visited[i][j] = board[i][j] != '.';
            }
        }
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int r, int c) {
        if ( r >= 9) {
            return true;
        }
        if (!visited[r][c]) {
            visited[r][c] = true;
            for(int i = 1; i <= 9; i++) {
                board[r][c] = (char)(i + '0');
                if (isValidSudoku(board, r, c) && solveSudoku(board, c == 8 ? r + 1 : r, c == 8 ? 0 : c + 1)) {
                    return true;
                }
            }
            visited[r][c] = false;
        }
        else {
            return solveSudoku(board, c == 8 ? r + 1 : r, c == 8 ? 0 : c + 1);
        }
        return false;
    }
    public boolean isValidSudoku(char[][] board, int r, int c) {
        if (validateRow(board, r, c) && validateCol(board,r,c) && validateCube(board, r,c)) {
            return true;
        }
        return false;
    }

    private boolean validateRow(char[][] board, int r, int c) {
        boolean[] cache = new boolean[9];
        for(int i = 0; i < 9; i++) {
            if (visited[r][i]) {
                if (cache[board[r][i] - '1']) {
                    return false;
                }
                cache[board[r][i] - '1'] = true;
            }
        }

        return true;
    }

    private boolean validateCol(char[][] board, int r, int c) {
        boolean[] cache = new boolean[9];
        for(int i = 0; i < 9; i++) {
            if (visited[i][c] ) {
                if (cache[board[i][c] - '1']) {
                    return false;
                }
                cache[board[i][c] - '1'] = true;
            }
        }
        return true;
    }

    private boolean validateCube(char[][] board, int r, int c) {
        int rStart = r / 3 * 3, cStart = c / 3 * 3;
        boolean[] cache = new boolean[9];
        for(int i = rStart; i < rStart + 3; i++) {
            for(int j = cStart; j < cStart + 3; j++) {
                if (visited[i][j]) {
                    if (cache[board[i][j] - '1']) {
                        return false;
                    }
                    cache[board[i][j] - '1'] = true;
                }
            }
        }
        return true;
    }
}
