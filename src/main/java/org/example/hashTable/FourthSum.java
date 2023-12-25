package org.example.hashTable;

import java.util.HashMap;

public class FourthSum {
}
/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，
 * 请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 例如:
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
class Solution15 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                 int sum = num1 + num2;
                //getOrDefault:根据key找value,找到返回value,没有找到返回默认值
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int target = 0 - (num3 + num4);//a + b = 0 - (c + d) ==> a + b + c + d = 0
                res += hashMap.getOrDefault(target , 0);
            }
        }
        return res;
    }
}
