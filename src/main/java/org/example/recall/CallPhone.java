package org.example.recall;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class CallPhone {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 答案可以按 任意顺序 返回。
     *
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    class Solution61 {
        List<String> result;
        public List<String> letterCombinations(String digits) {
            result = new ArrayList<>();
            if(digits == null || digits.length() == 0){
                return result;
            }
            String[] strNum = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            traversal(digits, 0, strNum);
            return result;
        }
        StringBuilder temp = new StringBuilder();
        private void traversal(String digits, int index, String[] strNum) {
            if (index == digits.length()){
                result.add(temp.toString());
                return;
            }
            //获取到数字所对应的字符串  减‘0’为了把字符转成数字
            String str = strNum[digits.charAt(index) - '0'];
            for (int i = 0; i < str.length(); i++) {
                temp.append(str.charAt(i));
                traversal(digits, index + 1, strNum);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

}
