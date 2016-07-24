package com.xuan.string_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 7/20/16.
 */
public class WordLadderII_128 {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (beginWord.equals(endWord)) {
            result.add(Arrays.asList(beginWord));
            return result;
        }
        wordList.add(endWord);
        Map<String, List<String>> previous = new HashMap<>(wordList.size());
        for(String s : wordList) {
            previous.put(s, new LinkedList<>());
        }
        Set<String> toBeDeleted;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean isEnd = false;
        int step = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            toBeDeleted = new HashSet<>();
            for(int i = 0; i < size; i++) {
                String s = queue.poll();
                char[] c = s.toCharArray();
                for(int j = 0; j < c.length; j++) {
                    for(int k = 0; k < 26; k++) {
                        if (c[j] != (k + 'a')) {
                            c[j] = (char) (k + 'a');
                            String t = new String(c);
                            if (!isEnd && t.equals(endWord)) {
                                isEnd = true;
                            }
                            if (wordList.contains(t)) {
                                if (!toBeDeleted.contains(t) ) {
                                    queue.offer(t);
                                    toBeDeleted.add(t);
                                }
                                previous.get(t).add(s);
                            }
                        }
                    }
                    c[j] = s.charAt(j);
                }
            }
            if (isEnd) {
                break;
            }
            for(String d : toBeDeleted) {
                wordList.remove(d);
            }
        }
        if (!isEnd) {
            return result;
        }
        constructPath(previous, endWord, step -1, new String[step], result);
        return result;
    }

    private void constructPath(Map<String, List<String>> previous, String curr, int index, String[] path, List<List<String>> result) {
        if (index == 0) {
            path[0] = curr;
            result.add(new ArrayList<>(Arrays.asList(path)));
            return;
        }
        path[index] = curr;
        for(String s : previous.get(curr)) {
            constructPath(previous, s, index -1, path, result);
        }
    }
}
