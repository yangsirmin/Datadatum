package org.example.binaryTree;

public class PathSum {
    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
     * 如果存在，返回 true ；否则，返回 false 。
     */
    class Solution42 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null){
                return false;
            }
            targetSum -= root.val;
            return traversal(root, targetSum);
        }

        private boolean traversal(TreeNode root, int targetSum) {
            if (root.left == null && root.right == null && targetSum == 0){
                return true;
            }
            if (root.left == null && root.right == null && targetSum != 0){
                return false;
            }
            if (root.left != null){
                if (traversal(root.left, targetSum - root.left.val)){
                    return true;
                }
                /*
                targetSum -= root.left.val;
                if (traversal(root.left, targetSum)){
                    return true;
                }
                targetSum += root.left.val;
                */
            }
            if (root.right != null){
                if (traversal(root.right, targetSum - root.right.val)){
                    return true;
                }
            }
            return false;
        }
    }
}
