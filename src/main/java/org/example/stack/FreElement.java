package org.example.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FreElement {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
     * 你可以按 任意顺序 返回答案。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     */

    class Solution28 {
        public int[] topKFrequent(int[] nums, int k) {
            //lambda 表达式设置优先级队列从大到小存储 o1 - o2  ， 为从小到大o2 - o1
            //排序规则为 value值大小
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            Map<Integer, Integer> map = new HashMap<>();//key为值   value为值出现的次数
            int[] res = new int[k];
            for (int num : nums) {
                /**
                 * default V getOrDefault(Object key, V defaultValue) {
                 *         V v;
                 *         return (((v = get(key)) != null) || containsKey(key))
                 *             ? v
                 *             : defaultValue;
                 *     }
                 */
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int[] temp = new int[2];
                temp[0] = entry.getKey();
                temp[1] = entry.getValue();
                pq.offer(temp);
                //下面的代码是根据小根堆实现的，我只保留优先队列的最后的k个，
                // 只要超出了k我就将最小的弹出，剩余的k个就是答案
                if (pq.size() > k){
                    pq.poll();
                }
            }
            //取出优先队列的元素
            for (int i = 0; i < k; i++) {
                res[i] = pq.poll()[0];
            }

            return res;
        }
    }
}
