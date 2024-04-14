package org.example.binaryTree;

import com.sun.source.tree.Tree;

public class CommonRoot {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     */
    class Solution53 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null){
                return root;
            }
            if (root == p || root == q){
                return root;
            }
            //后续遍历
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null){
                return root;
            } else if (left == null && right != null) {
                return right;
            } else if (left != null && right == null) {
                return left;
            }else {
                return null;
            }
        }
    }
}
