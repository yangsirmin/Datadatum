package org.example.binaryTree;

public class Synmetry {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     */
    class Solution34 {
        //递归
        public boolean isSymmetric(TreeNode root) {
                return compareSyn(root.left, root.right);
        }

        private boolean compareSyn(TreeNode left, TreeNode right) {
            if (left == null && right != null){
                return false;
            }
            if (left != null && right == null){
                return false;
            }

            if (left == null && right == null){
                return true;
            }
            //先判断是否为null,防止报空指针异常
            if (left.val != right.val){
                return false;
            }
            boolean outCompare = compareSyn(left.left, right.right);
            boolean inCompare = compareSyn(left.right, right.left);
            return outCompare && inCompare;
        }
    }
}
