package com.xuan.array_related;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 8/2/16.
 */
public class WordSearchII_212 {
    class TrieNode {
        boolean isEnd;
        TrieNode[] next;
        public TrieNode() {
            next = new TrieNode[26];
        }

        public void addWord(String word) {
            TrieNode node = this;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isEnd = true;
        }
    }


    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(String word : words) {
            root.addWord(word);
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root,visited, new StringBuilder(), result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode parent, boolean[][] visited, StringBuilder sb, List<String> result) {
        char c = board[i][j];
        visited[i][j] = true;
        TrieNode node = parent.next[c - 'a'];
        if (node != null) {
            sb.append(c);
            if (node.isEnd) {
                result.add(sb.toString());
                node.isEnd = false;
            }
            if (i > 0 && !visited[i - 1][j]) {
                dfs(board, i - 1, j, node, visited, sb, result);
            }
            if (i < board.length - 1 && !visited[i + 1][j]) {
                dfs(board, i + 1, j, node, visited, sb, result);
            }
            if (j > 0 && !visited[i][j - 1]) {
                dfs(board, i, j - 1, node, visited, sb, result);
            }
            if (j < board[0].length - 1 && !visited[i][j + 1]) {
                dfs(board, i, j + 1, node, visited, sb, result);
            }

            sb.deleteCharAt(sb.length() -1);
        }
        visited[i][j] = false;
    }
}
