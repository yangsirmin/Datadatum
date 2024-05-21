package org.example.greed;

import java.util.Arrays;

public class MaxSum {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组
     * 是数组中的一个连续部分。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     */
    class Solution74 {
        public int maxSubArray(int[] nums) {

            if (nums.length == 1){
                return nums[0];
            }
            int result = Integer.MIN_VALUE;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += nums[i];
                if (count <= 0){
                    count = 0;
                }
                result = Integer.max(count, result);
            }
            if (result == 0){
                result = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    result = Integer.max(nums[i], result);
                }
            }
            return result;
        }
    }
}
