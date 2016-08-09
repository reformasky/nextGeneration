package com.xuan.other;

/**
 * Created by xzhou2 on 8/1/16.
 */

public class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
        root.isEnd = true;
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        root.addWord(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.search(word, 0);
    }
}