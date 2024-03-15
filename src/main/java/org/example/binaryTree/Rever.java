package org.example.binaryTree;

public class Rever {
    class Solution33 {
        /**
         * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            //前序
            if (root == null){
                return null;
            }
            swapChild(root);
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

        private void swapChild(TreeNode root) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
}
