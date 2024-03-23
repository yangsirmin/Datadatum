package org.example.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Paths {
    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     */
    class Solution39 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();//结果集
            if (root == null){
                return res;
            }
            List<Integer> paths = new ArrayList<>();//记录路径
            traversal(root, paths, res);
            return res;
        }

        private void traversal(TreeNode node, List<Integer> paths, List<String> res) {
            //使用前序遍历
            //中
            paths.add(node.val);
            if (node.left == null && node.right == null){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < paths.size() - 1; i++) {
                    sb = sb.append(paths.get(i) + "->");
                }
                //记录最后一个节点
                sb = sb.append(paths.get(paths.size() - 1));
                res.add(sb.toString());//收集一个路径
            }
            //左
            if (node.left != null){
                traversal(node.left, paths, res);
                paths.remove(paths.size() - 1);
            }
            //右
            if (node.right != null){
                traversal(node.right, paths, res);
                paths.remove(paths.size() - 1);
            }
        }
    }
}
