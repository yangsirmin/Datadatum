package org.example.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset {
    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
     * 子集
     * （幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    class Solution66 {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> subsets(int[] nums) {
            backTracking(nums, 0);
            return result;
        }

        private void backTracking(int[] nums, int startIndex) {
            if (path.size() > nums.length){
                return;
            }
            result.add(new ArrayList<>(path));
            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
                backTracking(nums, i + 1);
                path.removeLast();
            }
        }
    }
}
