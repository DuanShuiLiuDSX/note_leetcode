package com.company.train1;

/**
 * @author cz
 * @Description  将root1 root2 左节点、右节点 递归进去求解
 * @date 2021/12/23 14:12
 **/
public class No617 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if(root1==null) return root2;
            if(root2==null) return root1;

            TreeNode res = new TreeNode();
            res.val = root1.val + root2.val;
            res.left = mergeTrees(root1.left, root2.left);
            res.right = mergeTrees(root1.right, root2.right);
            return res;
        }
    }
}
