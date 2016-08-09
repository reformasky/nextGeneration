package com.xuan.other;

/**
 * Created by xzhou2 on 8/1/16.
 */


class TrieNode{
    boolean isEnd;
    TrieNode[] next;
    TrieNode() {
        next = new TrieNode[26];
    }

    public void addWord(String word) {
        TrieNode node = this;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next[c- 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word, int index) {
        if (index == word.length()) {
            return isEnd;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for(TrieNode n : next) {
                if (n != null && n.search(word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (next[c - 'a'] != null) {
                return next[c - 'a'].search(word, index + 1);
            } else {
                return false;
            }
        }
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.isEnd = true;
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.addWord(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode end = getEnd(word);
        return end != null && end.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode end = getEnd(prefix);
        return end != null;
    }

    private TrieNode getEnd(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                return null;
            }
            node = node.next[c - 'a'];
        }
        return node;
    }
}