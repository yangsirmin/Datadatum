package org.example.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class In extends TreeNode{
    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     */
//    class Solution30 {
//        public List<Integer> inorderTraversal(TreeNode root) {
//            //递归
//            List<Integer> result = new ArrayList<>();
//            inorder(root, result);
//            return result;
//        }
//
//        private void inorder(TreeNode root, List<Integer> result) {
//            if (root == null){
//                return;
//            }
//            //中序 左中右
//            inorder(root.left, result);
//            result.add(root.val);
//            inorder(root.right, result);
//        }
//    }
    public List<Integer> inorderTraversal(TreeNode root) {
        // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
