package org.example.recall;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GroupSum {
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
     * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
     * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。
     * 如果至少一个数字的被选数量不同，则两种组合是不同的。
     */
    class Solution62 {
        List<List<Integer>> result;
        LinkedList<Integer> path;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();
            path = new LinkedList<>();
            Arrays.sort(candidates);//排序
            backTrack(candidates, target, 0, 0);
            return result;
        }

        private void backTrack(int[] candidates, int target, int startIndex, int sum) {
            if (sum == target){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                if (sum + candidates[i] > target){
                    return;
                }
                path.add(candidates[i]);
                backTrack(candidates, target, i, sum + candidates[i]);
                path.removeLast();
            }
        }
    }
}
