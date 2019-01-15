package com.xuan.linkedlist_realted;

import com.xuan.util.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by xzhou2 on 6/16/16.
 */
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Entry[] entries = new Entry[indexes.length];
        for(int i = 0; i < entries.length; i++) {
            entries[i] = new Entry(indexes[i], sources[i], targets[i]);
        }
        Arrays.sort(entries, new Comparator<Entry>() {
            @Override
            public int compare(Entry a, Entry b) {
                return Integer.compare(a.idx, b.idx);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0, idx = 0; i < S.length(); i++) {
            if (i == entries[idx].idx) {
                if (S.startsWith(entries[idx].src,i)) {
                    sb.append(entries[idx].tar);
                    i += entries[idx].src.length();
                }
                i--;
                idx++;
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    class Entry {
        int idx;
        String src;
        String tar;
        Entry(int i, String s, String t) {
            idx = i;
            src = s;
            tar = t;
        }
    }
}
