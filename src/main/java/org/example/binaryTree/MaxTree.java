package org.example.binaryTree;

import com.sun.source.tree.Tree;

public class MaxTree {
    /**
     * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
     *
     * 创建一个根节点，其值为 nums 中的最大值。
     * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
     * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
     * 返回 nums 构建的 最大二叉树 。
     */
    class Solution44 {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return createMaxTree(nums, 0, nums.length);
        }

        private TreeNode createMaxTree(int[] nums, int leftIndex, int rightIndex) {
            if(rightIndex - leftIndex < 1){//没有元素
                return null;
            }
            if (rightIndex - leftIndex == 1){//只有一个元素
                return new TreeNode(nums[leftIndex]);
            }
            //最大值及其下标
            int maxIndex = leftIndex;
            int maxValue = nums[maxIndex];
            //前序 中
            for (int i = leftIndex + 1; i < rightIndex; i++) {
                if (nums[i] > maxValue){
                    maxValue = nums[i];
                    maxIndex = i;
                }
            }
            TreeNode root = new TreeNode(maxValue);
            //左右子树用最大下标去分割
            root.left = createMaxTree(nums, leftIndex, maxIndex);
            root.right = createMaxTree(nums, maxIndex + 1, rightIndex);
            return root;
        }
    }
}
