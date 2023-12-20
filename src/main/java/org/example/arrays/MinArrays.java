package org.example.arrays;

public class MinArrays {
}
/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 */
class Solution4 {
    public int minSubArrayLen(int target, int[] nums) {
        int slowIndex = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            sum += nums[fastIndex];
            while (sum >= target){
                minLength = Integer.min(minLength, fastIndex - slowIndex + 1);//取最小长度
                sum -= nums[slowIndex++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
