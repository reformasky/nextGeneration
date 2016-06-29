package com.xuan.array_related;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xzhou2 on 6/28/16.
 */
public class SolveSudoku_37Test {
    SolveSudoku_37 solveSudoku_37 = new SolveSudoku_37();
    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][] {
                {
                        new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."}
                }
        };
    }

    @Test(dataProvider = "data")
    public void test(String[] data) {
        char[][] board = new char[9][9];
        for(int i = 0; i < 9; i++) {
            board[i] = data[i].toCharArray();
        }
        solveSudoku_37.solveSudoku(board);
        Assert.assertNotNull(board);
    }
}
