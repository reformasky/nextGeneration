package com.xuan.string_related;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by xzhou2 on 8/30/16.
 */
public class RemoveDuplicate_316 {
  /*  public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            count[c - 'a']++;
        }
        for(char c : arr) {
            count[c - 'a']--;
            if (visited[c - 'a']) { continue;}
            while(!stack.isEmpty() && count[stack.peek() - 'a'] > 0 && stack.peek() > c) {
                visited[stack.pop() - 'a'] = false;
            }
            visited[c - 'a'] = true;
            stack.push(c);

        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
*/
  public String removeDuplicateLetters(String s) {
      LinkedList<Integer>[] indexes = (LinkedList<Integer>[]) new LinkedList[26];
      boolean[] visited = new boolean[26];
      Arrays.fill(visited, true);
      for(int i = 0; i < 26; i++) {
          indexes[i] = new LinkedList<Integer>();
      }
      for(int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          indexes[c - 'a'].addLast(i);
          visited[c - 'a'] = false;
      }
      int count = 0;
      for(boolean v : visited) {count += v ? 0 : 1;}
      StringBuilder sb = new StringBuilder();
      while(count > 0 ) {
          for(int i = 0; i < 26; i++) {
              if (!visited[i]) {
                  int index = indexes[i].getFirst();
                  boolean valid = true;
                  for(int j = i + 1; j < 26; j++) {
                      if (!visited[j] && index > indexes[j].getLast()) {
                          valid = false;
                          break;
                      }
                  }
                  if (valid) {
                      visited[i] = true;
                      sb.append((char)(i + 'a'));
                      indexes[i] = new LinkedList<Integer>();
                      for(int j = 0; j < 26; j++) {
                          if (!visited[j]) {
                              while(indexes[j].getFirst() <= index) {
                                  indexes[j].removeFirst();
                              }
                          }
                      }
                      count--;
                      break;
                  }
              }
          }
      }
      return sb.toString();
  }

}
