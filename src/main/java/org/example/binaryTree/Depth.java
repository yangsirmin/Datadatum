package org.example.binaryTree;

public class Depth {

    class Solution35 {
        /**
         * 给定一个二叉树 root ，返回其最大深度。
         *
         * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if (root == null){
                return 0;
            }
            //后序遍历
            //左右中
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            int depth = Math.max(leftDepth, rightDepth) + 1;
            return depth;
        }
    }
}
