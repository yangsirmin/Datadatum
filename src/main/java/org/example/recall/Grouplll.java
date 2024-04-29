package org.example.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grouplll {
    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     *
     * 只使用数字1到9
     * 每个数字 最多使用一次
     * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     *
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     * 解释:
     * 1 + 2 + 6 = 9
     * 1 + 3 + 5 = 9
     * 2 + 3 + 4 = 9
     * 没有其他符合的组合了。
     */

    class Solution60 {
        List<List<Integer>> result;
        LinkedList<Integer> path;
        int sum;
        public List<List<Integer>> combinationSum3(int k, int n) {
            result = new ArrayList<>();
            path = new LinkedList<>();
            sum = 0;
            traversal(k, n, 1, sum);
            return result;
        }

        private void traversal(int k, int n, int startIndex, int sum) {
            if (path.size() >= k){
                if (sum == n){
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
                sum += i;
                if (sum > n){
                    return;
                }
                path.add(i);
                traversal(k, n, i + 1, sum);
                sum -= i;
                path.removeLast();
            }
        }
    }
}
