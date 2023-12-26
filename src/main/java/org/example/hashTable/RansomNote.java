package org.example.hashTable;

public class RansomNote {
}
/**
 * 给你两个字符串：ransomNote 和 magazine ，
 * 判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
class Solution16 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        //都是小写字母，直接new一个长度为26的数组
        int[] words = new int[26];
        for (char c : magazine.toCharArray()) {
            words[c - 'a'] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            words[c - 'a'] -= 1;
        }
        for (int word : words) {
            if (word < 0){
                return false;
            }
        }
        return true;
    }
}
