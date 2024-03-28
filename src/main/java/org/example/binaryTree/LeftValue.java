package org.example.binaryTree;

public class LeftValue {
    /**
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     *
     * 假设二叉树中至少有一个节点。
     */
    class Solution41 {
        private int maxDepth = Integer.MIN_VALUE;
        private int result;
        public int findBottomLeftValue(TreeNode root) {
            result = root.val;
            traversal(root, maxDepth);
            return result;
        }

        private void traversal(TreeNode node, int depth) {
            if(node == null){
                return;
            }
            if (node.left == null && node.right == null){
                if (depth > maxDepth){
                    result = node.val;
                    maxDepth = depth;
                }
            }
            if (node.left != null){
                depth++;
                traversal(node.left, depth);
                depth--;
            }
            if (node.right != null){
                depth++;
                traversal(node.right, depth);
                depth--;
            }
        }
    }
}
