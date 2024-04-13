package org.example.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Mode {
    /**
     * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，
     * 找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
     *
     * 如果树中有不止一个众数，可以按 任意顺序 返回。
     *
     * 假定 BST 满足如下定义：
     *
     * 结点左子树中所含节点的值 小于等于 当前节点的值
     * 结点右子树中所含节点的值 大于等于 当前节点的值
     * 左子树和右子树都是二叉搜索树
     */
    class Solution52 {
        List<Integer> result;
        TreeNode pre = null;
        int count;
        int maxCount;
        public int[] findMode(TreeNode root) {
            result = new ArrayList();
            traversal(root);
            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }

        private void traversal(TreeNode root) {
            if (root == null){
                return;
            }
            //中序遍历
            //左
            traversal(root.left);
            //中
            if (pre == null){
                count = 1;
            } else if (pre.val == root.val) {
                count++;
            }else {
                count = 1;
            }
            pre = root;
            if (count == maxCount){
                result.add(root.val);
            } else if (count > maxCount) {
                maxCount = count;
                result.clear();
                result.add(root.val);
            }
            //右
            traversal(root.right);

        }
    }
}
