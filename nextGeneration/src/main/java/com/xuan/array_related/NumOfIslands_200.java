package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/31/16.
 */
public class NumOfIslands_200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length ==0) {
            return 0;
        }
        int result = 0;
        int nRow = grid.length, nCol = grid[0].length;
        boolean[][] visited = new boolean[nRow][nCol];
        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    dfs(grid, i, j, visited);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        if (i > 0 && grid[i-1][j] == '1' && !visited[i-1][j]) {
            dfs(grid, i-1, j, visited);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1' && !visited[i+1][j]) {
            dfs(grid, i + 1, j, visited);
        }
        if (j > 0 && grid[i][j-1] == '1' && !visited[i][j-1]) {
            dfs(grid, i, j - 1, visited);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            dfs(grid, i, j + 1, visited);
        }
    }
}
