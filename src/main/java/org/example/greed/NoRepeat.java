package org.example.greed;

import java.util.Arrays;

public class NoRepeat {
    public static void main(String[] args) {
        int[][] intervals = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},
                {58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        Solution85 solution85 = new Solution85();
        solution85.eraseOverlapIntervals(intervals);

    }
    /**
     * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
     *
     *
     *
     * 示例 1:
     *
     * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * 输出: 1
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * 示例 2:
     *
     * 输入: intervals = [ [1,2], [1,2], [1,2] ]
     * 输出: 2
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * 示例 3:
     *
     * 输入: intervals = [ [1,2], [2,3] ]
     * 输出: 0
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     */
}
class Solution85 {
    public int eraseOverlapIntervals(int[][] intervals) {
//        Arrays.sort(intervals, (a, b) ->{
//            if (a[0] == b[0]) return a[1] - b[1];//升序
//            else return a[0] - b[0];//升序
//        });
        Arrays.sort(intervals, (a, b) ->{
            return Integer.compare(a[0], b[0]);
        });
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]){
                count++;
                //不能单纯的排序intervals[i][]，重叠了，选择右区间最小的
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return count;
    }
}
