package com.xuan.array_related;

/**
 * Created by xzhou2 on 6/28/16.
 */
public class ValidateSoduku_36 {
    public boolean isValidSudoku(char[][] board) {
        if (validateRow(board) && validateCol(board) && validateCube(board)) {
            return true;
        }
        return false;
    }

    private boolean validateRow(char[][] board) {
        for(int i = 0; i < 9; i++) {
            if (! validate(board[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean validateCol(char[][] board) {
        for(int i = 0; i < 9; i++) {
            char[] arr = new char[9];
            for(int j = 0; j < 9; j++) {
                arr[j] = board[j][i];
            }
            if (!validate(arr)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateCube(char[][] board) {
        for(int i = 0; i < 9; i++) {
            char[] arr = new char[9];
            int r = i / 3 * 3;
            int c = i % 3 * 3;
            int tr = r, tc = c;
            for(int j = 0; j < 9; j++) {
                if (tc == c + 3) {
                    tc = c;
                    tr++;
                }
                arr[j] = board[tr][tc++];
            }
            if (!validate(arr)) {
                return false;
            }
        }
        return true;

    }


    private boolean validate(char[] arr) {
        boolean[] cache = new boolean[9];
        for(char c : arr) {
            if (c != '.') {
                if (cache[c - '1']) {
                    return false;
                }
                cache[c - '1'] = true;
            }

        }
        return true;
    }
}
