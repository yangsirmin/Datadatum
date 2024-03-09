package org.example.binaryTree;

import org.example.binaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Pre extends TreeNode {

    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     */
    class Solution29 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorder(root, result);
            return result;
        }

        private void preorder(TreeNode root, List<Integer> result) {
            if (root == null){
                return;
            }
            //前序 中左右
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
    }
}
