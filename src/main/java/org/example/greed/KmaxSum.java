package org.example.greed;

import java.util.Arrays;

public class KmaxSum {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
     *
     * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
     * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
     *
     * 以这种方式修改数组后，返回数组 可能的最大和 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [4,2,3], k = 1
     * 输出：5
     * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
     * 示例 2：
     *
     * 输入：nums = [3,-1,0,2], k = 3
     * 输出：6
     * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
     * 示例 3：
     *
     * 输入：nums = [2,-3,-1,5,-4], k = 2
     * 输出：13
     * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
     */
    class Solution78 {
        public int largestSumAfterKNegations(int[] nums, int k) {
            Arrays.sort(nums);
            for (int i = 0; i < k; i++) {
                if (nums[0] <= 0){
                    nums[0] = -nums[0];
                    Arrays.sort(nums);
                }else {
                    nums[0] = -nums[0];
                }
            }
            return Arrays.stream(nums).sum();
        }
    }
}
