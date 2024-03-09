package org.example.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class In extends TreeNode{
    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     */
    class Solution30 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorder(root, result);
            return result;
        }

        private void inorder(TreeNode root, List<Integer> result) {
            if (root == null){
                return;
            }
            //中序 左中右
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }
    }
}
