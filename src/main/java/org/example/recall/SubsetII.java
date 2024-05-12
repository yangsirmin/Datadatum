package org.example.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetII {
    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
     * 子集
     * （幂集）。
     *
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     *
     * 示例 1:
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     */
    class Solution67 {
        //用used去重
        private boolean[] used;
        private List<List<Integer>> result;
        private LinkedList<Integer> path;
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            //把拿到的数组进行排序
            Arrays.sort(nums);
            //初始化used数组并填充
            used = new boolean[nums.length];
            Arrays.fill(used, false);
            result = new ArrayList<>();
            path = new LinkedList<>();
            backTracking(nums, 0);
            return result;
        }

        private void backTracking(int[] nums, int startIndex) {
            if (path.size() > nums.length){
                return;
            }
            //收集结果集，null也会收集
            result.add(new ArrayList<>(path));
            for (int i = startIndex; i < nums.length; i++) {
                //去重逻辑
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                backTracking(nums, i + 1);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
