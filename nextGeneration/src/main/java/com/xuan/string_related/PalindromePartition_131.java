package com.xuan.string_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xzhou2 on 7/20/16.
 */
public class PalindromePartition_131 {
    List<List<String>> resultLst;
    ArrayList<String> currLst;
    boolean[][] isPalindrome;
    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        isPalindrome = new boolean[s.length()][s.length()];
        buildPalindrome(s);
        backTrack(s,0);
        return resultLst;
    }
    public void backTrack(String s, int l){
        if(currLst.size()>0 //the initial str could be palindrome
                && l>=s.length()){
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome[l][i]){
                currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }

    private void buildPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for(int i = 0; i < s.length() -1; i++) {
            isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }
        for(int len = 3; len <= s.length(); len++) {
            for(int i = 0; i < s.length() - len + 1; i++) {
                int j = len + i -1;
                isPalindrome[i][j] = isPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }
    }







    List<List<String>>[][] cache;
    boolean[][] palindrome;
    public List<List<String>> partition_slow(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        cache = (List<List<String>>[][])(new List[s.length()][s.length()]);
        palindrome = new boolean[s.length()][s.length()];
        for(int i  = 0; i < s.length(); i++) {
            palindrome[i][i] = true;
        }
        for(int i = 0; i < s.length() -1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                palindrome[i][i+1] = true;
            }
        }
        for(int len = 3; len <= s.length(); len++) {
            for(int start = 0; start < s.length() - len + 1; start++) {
                int end = start + len - 1;
                palindrome[start][end] = (s.charAt(start) == s.charAt(end)) && (palindrome[start +1][end -1]);
            }
        }
        return helper(s.toCharArray(), 0, s.length() -1);
    }

    private List<List<String>> helper(char[] arr, int start, int end) {
        List<List<String>> result = new ArrayList<>();
        if (start < end) {
            if (cache[start][end] != null) {
                return cache[start][end];
            }
            for(int i = start; i < end; i++) {
                if(palindrome[start][i]) {
                    String curr = new String(arr, start, i - start + 1);
                    List<List<String>> pre = helper(arr, i + 1, end);
                    if (pre == null) {
                        continue;
                    }
                    for(List<String> p : pre) {
                        List<String> copy = new ArrayList<>(p.size() +1);
                        copy.add(curr);
                        for(String s : p) {
                            copy.add(s);
                        }
                        result.add(copy);
                    }
                }
            }
            if(palindrome[start][end]){
                result.add(new ArrayList<>(Arrays.asList(new String(arr, start, end - start + 1) )));
            }
            cache[start][end] = result;
            return result;

        } else if (start == end) {
            result.add(new ArrayList<>(Arrays.asList(new String(arr, start, 1))));
            return result;
        }
        return null;
    }

}
