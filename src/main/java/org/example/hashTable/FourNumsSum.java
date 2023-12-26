package org.example.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumsSum {
}
/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组
 * [nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target){
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]){//i去重
                continue;
            }
            for (int j = i + 1; j < nums.length; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]){//j去重
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left){
                    Long sum = (long) (nums[i] + nums[j] + nums[right] + nums[left]);
                    if (sum > target){
                        right--;
                    } else if (sum < target) {
                        left++;
                    }else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]){//right去重
                            right--;
                        }
                        while (right > left && nums[left] == nums[left + 1]){//left去重
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
