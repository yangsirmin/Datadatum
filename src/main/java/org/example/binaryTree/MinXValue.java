package org.example.binaryTree;

public class MinXValue {
    /**
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     *
     * 差值是一个正数，其数值等于两值之差的绝对值。
     */
    class Solution51 {
        private int result = Integer.MAX_VALUE;
        private TreeNode pre = null;
        public int getMinimumDifference(TreeNode root) {
            if (root == null){
                return Integer.MAX_VALUE;
            }
            //中序遍历
            getMinimumDifference(root.left);
            if (pre != null){
                result = Math.min(result, root.val - pre.val);
            }
            pre = root;
            getMinimumDifference(root.right);
            return result;
        }
    }
}
