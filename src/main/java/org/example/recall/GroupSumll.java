package org.example.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GroupSumll {
    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
     * 找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     */
    class Solution63 {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        //使用used来控制去重   false为未被使用；ture为被使用
        boolean[] used;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates == null || candidates.length < 0){
                return result;
            }
            used = new boolean[candidates.length];
            Arrays.fill(used, false);
            Arrays.sort(candidates);
            backTracking(candidates, target, 0, 0);
            return result;
        }

        private void backTracking(int[] candidates, int target, int startIndex, int sum) {
            if (sum == target){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                if (sum + candidates[i] > target){
                    return;
                }
                //去重逻辑
                if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false){
                    continue;
                }
                used[i] = true;
                path.add(candidates[i]);
                backTracking(candidates, target, i + 1, sum + candidates[i]);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
