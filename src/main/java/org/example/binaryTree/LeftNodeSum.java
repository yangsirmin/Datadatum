package org.example.binaryTree;

public class LeftNodeSum {
    /**
     * 给定二叉树的根节点 root ，返回所有左叶子之和。
     */

    class Solution40 {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null){
                return 0;
            }
            //后序遍历
            //左
            int leftNum = sumOfLeftLeaves(root.left);
            //右
            int rightNum = sumOfLeftLeaves(root.right);
            if (root.left != null && root.left.left == null && root.left.right == null){
                leftNum = root.left.val;
            }
            int sum = leftNum + rightNum;
            return sum;
        }
    }
}
