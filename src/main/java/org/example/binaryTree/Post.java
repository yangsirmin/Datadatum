package org.example.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Post extends TreeNode {
    /**
     * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
     *
     *
     */

    class Solution31 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            postorder(root, result);
            return result;
        }

        private void postorder(TreeNode root, List<Integer> result) {
            if (root == null){
                return;
            }
            //后序  左右中
            postorder(root.left, result);
            postorder(root.right, result);
            result.add(root.val);
        }
    }
}
