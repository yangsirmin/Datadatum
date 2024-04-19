package org.example.binaryTree;

public class DeleteSearchTree {
    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
     * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     */
    class Solution55 {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null){//没有找到key或者root为null
                return null;
            }
            if (root.val == key){
                //分为5中情况：1.没找到（已处理）
                if (root.left == null && root.right == null){//2.删除节点为叶子节点
                    return null;
                } else if (root.left != null && root.right == null) {//3.左不为null，右为null
                    return root.left;
                } else if (root.left == null && root.right != null) {//4.左为null，右不为null
                    return root.right;
                }else {//5.左右都不为null
                    TreeNode cur = root.right;
                    //一直往左遍历,遍历到叶子节点
                    while (cur.left != null){
                        cur = cur.left;
                    }
                    //把删除节点的左节点放到右节点的左叶子节点
                    cur.left = root.left;
                    return root.right;
                }
            }
            if (key < root.val){
                root.left = deleteNode(root.left, key);
            }
            if (key > root.val){
                root.right = deleteNode(root.right, key);
            }
            return root;
        }
    }
}
