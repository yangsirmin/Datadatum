package org.example.binaryTree;

public class InsertSearchTree {
    /**
     * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。
     * 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
     *
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
     */
    class Solution54 {
        /**
         * 所有的值都可以在叶子节点插入
         * @param root
         * @param val
         * @return
         */
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root == null){
                return new TreeNode(val);
            }
            if(val < root.val){
                root.left = insertIntoBST(root.left, val);
            }
            if(val > root.val){
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }
}
