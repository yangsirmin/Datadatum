package org.example.greed;

import java.util.Arrays;

public class Candy {
    /**
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     * <p>
     * 你需要按照以下要求，给这些孩子分发糖果：
     * <p>
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：ratings = [1,0,2]
     * 输出：5
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
     * 示例 2：
     * <p>
     * 输入：ratings = [1,2,2]
     * 输出：4
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
     * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
     */
    class Solution80 {
        public int candy(int[] ratings) {
            int[] candy = new int[ratings.length];
            Arrays.fill(candy, 1);
            for (int i = 1; i < ratings.length; i++) {
                //右边孩子比左边孩子大
                if (ratings[i] > ratings[i - 1]) {
                    candy[i] = candy[i - 1] + 1;
                }
            }
            for (int i = ratings.length - 2; i >= 0 ; i--) {
                //左边孩子比右边孩子大
                if (ratings[i] > ratings[i + 1]){
                    candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
                }
            }
            return Arrays.stream(candy).sum();
        }
    }
}
