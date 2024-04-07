package org.example.binaryTree;

public class SearchTree {
    /**
     * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
     *
     * 你需要在 BST 中找到节点值等于 val 的节点。
     * 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
     *
     * 搜索二叉树，左节点比根节点小，右节点比根节点大
     */
    class Solution46 {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val){
                return root;
            }
            TreeNode result = null;
            if (val < root.val){
                result = searchBST(root.left, val);
            }
            if (val > root.val){
                result = searchBST(root.right, val);
            }
            return result;
        }
    }
}
