package org.example.binaryTree;

import com.sun.source.tree.Tree;

public class ArrayTraversalBanlanceSearch {
    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，
     * 请你将其转换为一棵平衡
     *  二叉搜索树。
     */
    class Solution57 {
        public TreeNode sortedArrayToBST(int[] nums) {
            TreeNode root = traversal(nums,0, nums.length - 1);
            return root;
        }

        private TreeNode traversal(int[] nums, int left, int right) {
            if (left > right){
                return null;
            }
            int mid = left + ((right - left) >> 1);
            TreeNode root = new TreeNode(nums[mid]);
            root.left = traversal(nums, left, mid - 1);
            root.right = traversal(nums, mid + 1, right);
            return root;
        }
    }
}
