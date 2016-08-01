package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/28/16.
 */
public class DungeonGame_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) {
            return 1;
        }
        int m = dungeon.length, n = dungeon[0].length;
        int[] min = new int[n];
        min[n - 1] = dungeon[m-1][n-1] > 0 ? 1 : (1 - dungeon[m-1][n-1]);
        for(int i = n - 2; i >= 0; i--) {
            min[i] = dungeon[m - 1][i] >= min[i + 1] ? 1 : (min[i + 1] - dungeon[m-1][i]);
        }
        for(int i = m - 2; i >= 0; i--) {
            min[n - 1] = dungeon[i][n - 1] >= min[n - 1] ? 1 : (min[n-1] - dungeon[i][n-1]);
            for(int j = n - 2; j >= 0; j--) {
                int tmp = Math.min(min[j], min[j + 1]);
                min[j] = dungeon[i][j] >= tmp ? 1 : (tmp - dungeon[i][j]);
            }
        }
        return min[0];
    }
}
