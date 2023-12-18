package org.example;

public class Vrille {
}
/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
 */
class Solution5 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int start = 0;
        int loop = 0;
        int count = 1;
        int i, j;
        while(loop++ < n/2){
            for (j = start; j < n - loop; j++){
                res[start][j] = count++;
            }
            for (i = start; i < n - loop; i++){
                res[i][j] = count++;
            }
            for (; j >= loop; j--){
                res[i][j] = count++;
            }
            for (; i >= loop; i--){
                res[i][j] = count++;
            }
            start++;
        }
        if (n % 2 == 1){
            res[start][start] = count;
        }
        return res;
    }
}