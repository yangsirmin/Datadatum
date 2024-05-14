package org.example.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllOrder {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    class Solution69 {
        List<List<Integer>> result;
        LinkedList<Integer> path;
        public List<List<Integer>> permute(int[] nums) {
            result = new ArrayList<>();
            path = new LinkedList<>();
            backTraking(nums);
            return result;
        }

        private void backTraking(int[] nums) {
            if (path.size() == nums.length){
                result.add(new ArrayList<>(path));
            }
            for (int i = 0; i < nums.length; i++) {
                if (path.contains(nums[i])){
                    continue;
                }
                path.add(nums[i]);
                backTraking(nums);
                path.removeLast();
            }
        }
    }
}
