package org.example.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sequence {
    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。
     * （即逐层地，从左到右访问所有节点）。
     *
     *输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     * 示例 2：
     *
     * 输入：root = [1]
     * 输出：[[1]]
     * 示例 3：
     *
     * 输入：root = []
     * 输出：[]
     *
     */

    class Solution32 {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            //迭代
            cheekFun(root);
            return result;
        }

        private void cheekFun(TreeNode root) {
            if (root == null){
                return;
            }
            Queue<TreeNode> node = new LinkedList<>();
            node.offer(root);

            while (!node.isEmpty()){
                List<Integer> tempResult = new ArrayList<>();
                int len = node.size();
                while (len > 0){
                    TreeNode tempNode = node.poll();
                    tempResult.add(tempNode.val);
                    if (tempNode.left != null){
                        node.add(tempNode.left);
                    }
                    if (tempNode.right != null){
                        node.add(tempNode.right);
                    }
                    len--;
                }
                result.add(tempResult);
            }
        }
    }
}
