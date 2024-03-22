package org.example.binaryTree;

public class NodeNum37 {
    /**
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     *
     * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
     * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     *
     * 完全二叉树的计算  2的n次方 - 1 ： 2 << n - 1    n为层数
     */
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null){
                return 0;
            }
            int leftNode = 0, rightNode = 0;
            TreeNode left = root.left, right = root.right;
            while (left != null){
                leftNode++;
                left = left.left;
            }
            while (right != null){
                rightNode++;
                right = right.right;
            }
            if (leftNode == rightNode){
                //2先向左移 ==> 加括号
                return (2 << leftNode) - 1;
            }
            //普通二叉树遍历  后序遍历 ==> 左右中
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
