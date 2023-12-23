package org.example.hashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNum {
    public static void main(String[] args) {
        new Solution13().isHappy(19);
    }
}
/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
class Solution13 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getNum(n);
        }
        return n == 1;
    }
    public int getNum(int n){
        int res = 0;
        int temp = 0;
        while (n > 0){
            temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}

