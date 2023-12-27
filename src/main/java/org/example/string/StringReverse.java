package org.example.string;

public class StringReverse {
}

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * 输入字符串以字符数组 s 的形式给出。
 *
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
class Solution19 {
    public void reverseString(char[] s) {
        int start = 0;
        int tail = s.length - 1;
        char temp;
        while(start < tail){
            temp = s[start];
            s[start] = s[tail];
            s[tail] = temp;
            start++;
            tail--;
        }
    }
}
