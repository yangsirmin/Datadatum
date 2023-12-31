package org.example.string;

public class RepeatString {
}
/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 *
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 */
class Solution23 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int j = 0;
        char[] chars = s.toCharArray();
        int[] next = new int[len];
        //初始化next
        next[0] = 0;
        //得到next, i从1开始
        for (int i = 1; i < len; i++) {
            while (j > 0 && chars[i] != chars[j]){
                j = next[j - 1];
            }
            if (chars[i] == chars[j]){
                j++;
            }
            next[i] = j;
        }
        //next数组最后一个元素不等于0，表示有重复元素
        //长度 整除余 长度减去next数组的前一位数组（得到重复字符长度）==>如果为0，则字符串由一个重复子字符串组成
        if (next[len - 1] > 0 && len % (len - next[len - 1]) == 0){
            return true;
        }
        return false;
    }
}