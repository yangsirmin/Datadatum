package org.example.binaryTree;

public class MinDepth {

    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明：叶子节点是指没有子节点的节点。
     */

    class Solution36 {
        public int minDepth(TreeNode root) {
            if (root == null){
                return 0;
            }
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            if (root.left == null && root.right != null){
                return rightDepth + 1;
            }
            if (root.left != null && root.right == null){
                return leftDepth + 1;
            }
            int minDepth = Math.min(leftDepth, rightDepth) + 1;
            return minDepth;
        }
    }
}
