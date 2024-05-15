package org.example.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllOrderII {
    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     *
     *
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     */
    class Solution70 {
        List<List<Integer>> result;
        LinkedList<Integer> path;
        //使用used去重
        boolean[] used;
        public List<List<Integer>> permuteUnique(int[] nums) {
            result = new ArrayList<>();
            path = new LinkedList<>();
            used = new boolean[nums.length];
            Arrays.sort(nums);
            Arrays.fill(used, false);
            backTracking(nums);
            return result;
        }

        private void backTracking(int[] nums) {
            if (path.size() == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                //去重
                if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false){
                    continue;
                }
                //同一数枝下的数没被使用
                if (used[i] == false){
                    path.add(nums[i]);
                    used[i] = true;
                    backTracking(nums);
                    path.removeLast();
                    used[i] = false;
                }
            }
        }
    }
}
