package com.xuan.array_related;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 10/18/16.
 */
public class BattleShipOnABoard_419 {
    public int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int nRow = board.length, nCol = board[0].length;
        int res = 0;
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
                    res ++;
                }
            }
        }
        String[] secondaryKey = new String[]{ "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        return res;
    }
}
