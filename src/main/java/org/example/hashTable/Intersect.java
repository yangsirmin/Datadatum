package org.example.hashTable;

import java.util.HashSet;
import java.util.Set;

public class Intersect {
}
/**
 * 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
class Solution12 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        Set setNum1 = new HashSet();
        Set setNum2 = new HashSet();
        for (int i : nums1) {
            setNum1.add(i);
        }
        for (int i : nums2) {
            if (setNum1.contains(i)){//判断nums2值setNums1中是否存在
                setNum2.add(i);
            }
        }
        return setNum2.stream().mapToInt(value -> (int) value).toArray();
    }
}
