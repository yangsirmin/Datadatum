package org.example.binaryTree;

import org.example.binaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pre extends TreeNode {

    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     */
    class Solution29 {

//        public List<Integer> preorderTraversal(TreeNode root) {
//            //递归
//            List<Integer> result = new ArrayList<>();
//            preorder(root, result);
//            return result;
//        }
//
//        private void preorder(TreeNode root, List<Integer> result) {
//            if (root == null){
//                return;
//            }
//            //前序 中左右
//            result.add(root.val);
//            preorder(root.left, result);
//            preorder(root.right, result);
//        }


        public List<Integer> preorderTraversal(TreeNode root) {
            //迭代遍历   前序遍历顺序：中-左-右，入栈顺序：中-右-左
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }
            return result;
        }
    }
}
