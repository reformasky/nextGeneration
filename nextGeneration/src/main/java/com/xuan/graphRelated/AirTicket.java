package com.xuan.graphRelated;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AirTicket {
    class Solution {
        public boolean canTransform(String start, String end) {
            if (start.length() != end.length()) {
                return false;
            }

            return validRL(start, end) && validLX(start, end) && validRX(start, end);
        }

        private boolean validRL(String start, String end) {
            List<Character> s = new ArrayList<>(),
                    e = new ArrayList<>();
            for(char c : start.toCharArray()) {
                if (c != 'X') {
                    s.add(c);
                }
            }
            for(char c : end.toCharArray()) {
                if (c != 'X') {
                    e.add(c);
                }
            }
            return s.equals( e);
        }

        private boolean validLX(String start, String end) {
            List<Integer> s = new ArrayList<>(),
                    e = new ArrayList<>();
            int count = 0;
            for(int i = start.length() - 1; i >= 0; i--) {
                if (start.charAt(i) == 'L') {
                    s.add(count);
                } else if (start.charAt(i) == 'X') {
                    count++;
                }
            }
            count = 0;
            for(int i = end.length() - 1; i >= 0; i--) {
                if (end.charAt(i) == 'L') {
                    e.add(count);
                } else if (end.charAt(i) == 'X') {
                    count++;
                }
            }
            for(int i = 0; i < s.size(); i++) {
                if (s.get(i) > e.get(i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean validRX(String start, String end) {
            List<Integer> s = new ArrayList<>(),
                    e = new ArrayList<>();
            int count = 0;
            for(int i = 0; i < start.length(); i++) {
                if (start.charAt(i) == 'R') {
                    s.add(count);
                } else if (start.charAt(i) == 'X') {
                    count++;
                }
            }
            count = 0;
            for(int i = 0 ; i < end.length(); i++) {
                if (end.charAt(i) == 'R') {
                    e.add(count);
                } else if (end.charAt(i) == 'X') {
                    count++;
                }
            }
            for(int i = 0; i < s.size(); i++) {
                if (s.get(i) > e.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
