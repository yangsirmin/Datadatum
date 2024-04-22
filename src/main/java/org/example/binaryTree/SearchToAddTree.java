package org.example.binaryTree;

public class SearchToAddTree {
    /**
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
     * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     */
    class Solution {
        int pre = 0;
        public TreeNode convertBST(TreeNode root) {
            if (root == null){
                return null;
            }
            //右中左遍历
            convertBST(root.right);
            root.val += pre;
            pre = root.val;
            convertBST(root.left);
            return root;
        }
    }
}
