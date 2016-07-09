package com.xuan.array_related;

/**
 * Created by xzhou2 on 7/7/16.
 */
public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (dfs(board, visited,i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        boolean result = false;
        visited[i][j] = true;
        if (i >0 && !visited[i-1][j]) {
            result = dfs(board, visited, i - 1, j, word, index + 1);
        }
        if (!result && i < board.length - 1 && !visited[i+1][j]) {
            result = dfs(board, visited, i + 1, j, word, index + 1);
        }
        if (!result && j > 0 && !visited[i][j - 1]) {
            result = dfs(board, visited, i, j - 1, word, index + 1);
        }
        if (!result && j < board[0].length - 1 && !visited[i][j+1]) {
            result = dfs(board, visited, i, j + 1, word, index + 1);
        }
        visited[i][j] = false;
        return result;
    }
}
