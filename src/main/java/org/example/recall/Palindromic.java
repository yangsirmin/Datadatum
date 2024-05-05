package org.example.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Palindromic {
    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
     * 回文串
     *  。返回 s 所有可能的分割方案。
     */
    class Solution64 {
        List<List<String>> result = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        public List<List<String>> partition(String s) {
            traversal(0, s);
            return result;
        }

        private void traversal(int startIndex, String s) {
            if (startIndex >= s.length()){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                //判断是否为回文字符串
                if (ispalindromic(s, startIndex, i)){
                    path.add(s.substring(startIndex, i + 1));
                }else {
                    continue;
                }
                traversal(i + 1, s);
                path.removeLast();
            }
        }

        private boolean ispalindromic(String s, int startIndex, int end) {
            for (int i = startIndex, j = end; i < j; i++, j--){
                if (s.charAt(i) != s.charAt(j)){
                    return false;
                }
            }
            return true;
        }
    }
}
