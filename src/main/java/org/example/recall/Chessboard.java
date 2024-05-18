package org.example.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chessboard {
    // TODO
    /**
     * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     *
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     *
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     */
    class Solution71 {
        List<List<String>> result;
        public List<List<String>> solveNQueens(int n) {
            result = new ArrayList<>();
            char[][] chessboard = new char[n][n];
            for (char[] chars : chessboard) {
                Arrays.fill(chars, '.');
            }
            backTracking(n, 1, 1, chessboard);
            return result;
        }

        private void backTracking(int n, int row, int col, char[][] chessboard) {
            if (row == n){
                result.add(array2List(chessboard));
                return;
            }
            for (int i = 1; i <= n; i++) {
                if (isValid(n, i, col, chessboard)){
                    //因为行和列从1开始
                    chessboard[i - 1][col - 1] = 'Q';
                    backTracking(n, i, col + 1, chessboard);
                    chessboard[i][col] = '.';
                }
            }
        }

        private boolean isValid(int n, int row, int col, char[][] chessboard) {
            //判断列
            for (int i = 1; i < row; i++) {
                if (chessboard[i][col] == 'Q'){
                    return false;
                }
            }
            //判断右上角
            for (int i = row - 1, j = col + 1; i >= 1 && j <= n; i--, j++){
                if (chessboard[i][j] == 'Q'){
                    return false;
                }
            }
            //判断左上角
            for (int i = row - 1, j = col - 1; i >= 1 && j >= 1; i--, j--){
                if (chessboard[i][j] == 'Q'){
                    return false;
                }
            }
            return true;
        }

        private List<String> array2List(char[][] chessboard) {
            List<String> result = new ArrayList<>();
            for (char[] chars : chessboard) {
                result.add(String.copyValueOf(chars));
            }
            return result;
        }
    }
}
