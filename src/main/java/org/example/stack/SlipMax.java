package org.example.stack;

import java.util.ArrayDeque;

public class SlipMax {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     */

    class Solution27 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int[] res = new int[nums.length - k + 1];
            int idex = 0;
            for (int i = 0; i <= nums.length - 1; i++) {
                //队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
                while (!deque.isEmpty() && deque.peek() < i - k + 1){
                    deque.poll();
                }
                //若尾部值小于加入的值则移除尾部值
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                    deque.pollLast();
                }
                deque.offer(i);
                //满足滑动窗口k
                if (i >= k - 1){
                    res[idex++] = nums[deque.peek()];
                }
            }

            return res;
        }
    }
}
