package org.example;

public class Square {
}

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
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
