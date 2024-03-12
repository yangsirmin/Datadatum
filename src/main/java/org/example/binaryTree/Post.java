package org.example.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Post extends TreeNode {
    /**
     * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
     *
     *
     */

    class Solution31 {
//        public List<Integer> postorderTraversal(TreeNode root) {
        //递归
//            List<Integer> result = new ArrayList<>();
//            postorder(root, result);
//            return result;
//        }
//
//        private void postorder(TreeNode root, List<Integer> result) {
//            if (root == null){
//                return;
//            }
//            //后序  左右中
//            postorder(root.left, result);
//            postorder(root.right, result);
//            result.add(root.val);
//        }

        public List<Integer> postorderTraversal(TreeNode root) {
            //迭代遍历
            //后序遍历顺序 左-右-中 入栈顺序：中-左-右 ， 最后翻转结果
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.left != null){
                    stack.push(node.left);
                }
                if (node.right != null){
                    stack.push(node.right);
                }
            }
            //翻转 中-右-左 ---> 左-右-中
            Collections.reverse(result);
            return result;
        }
    }
}
