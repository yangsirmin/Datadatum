package org.example.binaryTree;

public class IsSearchTree {
    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     *
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    class Solution47 {
        private TreeNode pre = null;
        public boolean isValidBST(TreeNode root) {
            if (root == null){
                return true;
            }
            //中序
            if (!isValidBST(root.left)){
                return false;
            }
            if (pre != null && pre.val >= root.val){
                return false;
            }
            pre = root;
            if (!isValidBST(root.right)){
                return false;
            }
            return true;
        }
    }
}
