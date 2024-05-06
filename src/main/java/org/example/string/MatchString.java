package org.example.string;

public class MatchString {
//    public static void main(String[] args) {
//
//        new Solution22().strStr("aabaabaafa", "aabaaf");
//    }
}
/**
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
class Solution22 {
    public int strStr(String haystack, String needle) {
        if (needle == null){
            return 0;
        }
        int[] next = new int[needle.length()];
        //得到next数组
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j == needle.length()){
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    private void getNext(int[] next, String needle) {
        int j = 0;
        //初始化起始位置
        next[0] = 0;
        //i从1开始，与初始化位置比较
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)){
                j++;
                next[i] = j;
            }
        }
    }
}
