package org.example.binaryTree;

public class BalanceTree {
    class Solution38 {
        public boolean isBalanced(TreeNode root) {
            return getHigh(root) != -1;
        }

        private int getHigh(TreeNode root) {
            if (root == null){
                return 0;
            }
            //后序遍历  左右中
            int leftHeight = getHigh(root.left);
            if (leftHeight == -1){
                return -1;
            }
            int rightHeight = getHigh(root.right);
            if (rightHeight == -1){
                return -1;
            }
            int result;
            if (Math.abs(leftHeight - rightHeight) > 1){
                return -1;
            }else {
                result = Math.max(leftHeight, rightHeight) + 1;
            }
            return result;
        }
    }
}
