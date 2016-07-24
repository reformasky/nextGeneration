package com.xuan.string_related;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xzhou2 on 7/19/16.
 */
public class WordLadderI_127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int result = 1;
        Queue<String> queue1 = new ArrayDeque<>(),
                queue2 = new ArrayDeque<>();
        if (beginWord.equals(endWord)) {
            return result;
        }
        wordList.add(endWord);
        queue1.add(beginWord);
        wordList.remove(beginWord);
        char[] c;
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                Queue<String> queue = queue1;
                queue1 = queue2;
                queue2 = queue;
            }
            result++;
            while(!queue1.isEmpty()) {
                String s = queue1.poll();
                c = s.toCharArray();
                for(int i = 0; i < c.length; i++) {
                    for(int j = 0; j < 26; j++) {
                        if (j + 'a' == s.charAt(i)) {
                            continue;
                        }
                        c[i] = (char)(j + 'a');

                        String tmp = new String(c);
                        if (tmp.equals(endWord)) {
                            return result;
                        }
                        if (wordList.contains(tmp)) {
                            wordList.remove(tmp);
                            queue2.offer(tmp);
                        }
                    }
                    c[i] = s.charAt(i);
                }

            }
        }
        return 0;
    }
}
