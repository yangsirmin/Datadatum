package org.example.arrays;

public class Square {
}

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
class Solution3 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int tail = result.length - 1;
        while (left <= right){
            if (nums[left] * nums[left] > nums[right] * nums[right]){
                result[tail--] = nums[left] * nums[left++];
            }else {
                result[tail--] = nums[right] * nums[right--];
            }
        }
        return result;
    }
}
