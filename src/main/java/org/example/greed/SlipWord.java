package org.example.greed;

import java.util.ArrayList;
import java.util.List;

public class SlipWord {
    /**
     * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
     *
     * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
     *
     * 返回一个表示每个字符串片段的长度的列表。
     *
     *
     *
     * 示例 1：
     * 输入：s = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
     * 示例 2：
     *
     * 输入：s = "eccbbbbdec"
     * 输出：[10]
     */
    class Solution86 {
        public List<Integer> partitionLabels(String s) {
            //只有26个字母，27的数组长度足够
            int[] hash = new int[26];
            byte[] sBytes = s.getBytes();
            for (int i = 0; i < sBytes.length; i++) {
                hash[sBytes[i] - 'a'] = i;
            }
            //记录左界限，右界限
            int right = 0, left = 0;
            //结果集
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < sBytes.length; i++) {
                right = Math.max(right, hash[sBytes[i] - 'a']);
                if (i == right){
                    result.add(i - left + 1);
                    left = right + 1;
                }
            }
            return result;
        }
    }
}
