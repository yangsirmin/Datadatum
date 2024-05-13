package org.example.recall;

import java.lang.reflect.Array;
import java.util.*;

public class NoDescendingSubset {
    /**
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，
     * 递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     *
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     */
    class Solution68 {
        /**
         * 不能使用used去重，used需要排序，eg.[4, 7, 6, 7]
         */
//        List<List<Integer>> result;
//        LinkedList<Integer> path;
//        //used去重
//        boolean[] used;
//        public List<List<Integer>> findSubsequences(int[] nums) {
//            result = new ArrayList<>();
//            path = new LinkedList<>();
//            used = new boolean[nums.length];
//            Arrays.fill(used, false);
//            backTracking(nums, 0);
//            return result;
//        }
//
//        private void backTracking(int[] nums, int startIndex) {
//            if (path.size() >= 2){
//                result.add(new ArrayList<>(path));
//            }
//            for (int i = startIndex; i < nums.length; i++) {
//                //非递减判断逻辑
//                if (i > 0 && nums[i - 1] > nums[i]){
//                    continue;
//                }
//                //去重逻辑
//                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
//                    continue;
//                }
//                used[i] = true;
//                path.add(nums[i]);
//                backTracking(nums, i + 1);
//                used[i] = false;
//                path.removeLast();
//            }
//        }

        List<List<Integer>> result;
        LinkedList<Integer> path;
        //used去重
        public List<List<Integer>> findSubsequences(int[] nums) {
            result = new ArrayList<>();
            path = new LinkedList<>();
            backTracking(nums, 0);
            return result;
        }

        private void backTracking(int[] nums, int startIndex) {
            if (path.size() >= 2){
                result.add(new ArrayList<>(path));
            }
            //去重
            HashSet<Integer> hs = new HashSet<>();
            for (int i = startIndex; i < nums.length; i++) {
                //非递减判断,去重逻辑
                if (!path.isEmpty() && path.get(path.size() - 1) > nums[i] || hs.contains(nums[i])){
                    continue;
                }
                hs.add(nums[i]);
                path.add(nums[i]);
                backTracking(nums, i + 1);
                path.removeLast();
            }
        }
    }
}
