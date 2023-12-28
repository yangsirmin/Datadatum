package org.example.string;

public class ResverseStringWord {
    public static void main(String[] args) {
        String string = new Solution21().reverseWords("the sky is blue");
        System.out.println(string);
    }
}
/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 *
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 */
class Solution21 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        //去除多余的空隙
        chars = deleteExtraSpace(chars);
        //反转字符数组
        reserver(chars, 0, chars.length);
        //反转单词
        reserverWord(chars);
        return new String(chars);
    }

    private void reserverWord(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast <= chars.length; fast++) {
            if (fast == chars.length || chars[fast] == ' '){
                reserver(chars, slow, fast);
                slow = fast + 1;
            }
        }
    }

    private void reserver(char[] chars, int num1, int num2) {
        int left = num1;
        int right = num2 - 1;
        while (left < right){
            char temp;
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    private char[] deleteExtraSpace(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' '){
                if (slow != 0){
                    chars[slow++] = ' ';
                }
                while(fast < chars.length && chars[fast] != ' '){
                    chars[slow++] = chars[fast++];
                }
            }
        }
        //去除多余的空间
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }
}
