package org.example.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class CreateTree {
    /**
     * 给定两个整数数组 inorder 和 postorder ，
     * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
     */

    class Solution43 {
        Map<Integer, Integer> map;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            map = new HashMap();
            //把中序的值放入Map中
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            //左闭右开
            return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
        }

        private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
            if (inBegin >= inEnd || postBegin >= postEnd){
                return null;
            }
            //找到节点在中序的位置
            int treeNodeIndex = map.get(postorder[postEnd - 1]);
            //构造节点
            TreeNode root = new TreeNode(inorder[treeNodeIndex]);
            //保存中序左子树个数
            int lenOfLeft = treeNodeIndex - inBegin;
            root.left = findNode(inorder, inBegin, treeNodeIndex,
                    postorder, postBegin, postBegin + lenOfLeft);
            root.right = findNode(inorder, treeNodeIndex + 1, inEnd,
                    postorder, postBegin + lenOfLeft, postEnd - 1);
            return root;
        }
    }
}
