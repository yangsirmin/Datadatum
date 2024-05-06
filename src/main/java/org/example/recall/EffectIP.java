package org.example.recall;

import java.util.ArrayList;
import java.util.List;

public class EffectIP {
    public static void main(String[] args) {
        new Solution65().restoreIpAddresses("101023");
    }
    /**
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
     * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     *
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
     * 这些地址可以通过在 s 中插入 '.' 来形成。
     * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     */
}
class Solution65 {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12){
            return result;
        }
        backTracking(s, 0, 0);
        return result;
    }

    private void backTracking(String s, int startIndex, int pointNum) {
        if (pointNum == 3){
            if (isVail(s, startIndex, s.length() - 1)){
                result.add(s);
            };
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (!isVail(s, startIndex, i)){
                return;
            }
            //substring 左闭右开原则
            s = s.substring(0, i + 1) + "." + s.substring(i + 1);
            pointNum++;
            backTracking(s, i + 2, pointNum);
            //回溯，删掉逗点
            s = s.substring(0, i + 1) + s.substring(i + 2);
            pointNum--;
        }
    }

    private boolean isVail(String s, int startIndex, int end) {
        if (startIndex > end){//在进行回溯的时，startIndex可能大于end,因为startindex的值已 i + 2传入，在收集值的时候就有可能大于
            return false;
        }
        if (s.charAt(startIndex) == '0' && startIndex != end){//开头为0不合法
            return false;
        }
        int num = 0;
        for (int i = startIndex; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return false;
            }
            num = num * 10 + s.charAt(i) - '0';
            if (num > 255){//大于255不合法
                return false;
            }
        }
        return true;
    }
}
