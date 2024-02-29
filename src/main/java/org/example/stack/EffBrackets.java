package org.example.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class EffBrackets {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     */
    class Solution24 {
        public boolean isValid(String s) {
            //Deque<Character> deque = new LinkedList<>();
            Stack<Character> stack = new Stack<>();
            char ch;
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                if (ch == '['){
                    stack.push(']');
                } else if (ch == '{') {
                    stack.push('}');
                } else if (ch == '(') {
                    stack.push(')');
                } else if (stack.isEmpty() || ch != stack.peek()) {
                    return false;
                }else {
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
}
