package order.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cz
 * @Description 中序遍历、 先序、后序、
 * @date 2022/2/25 9:49
 **/
public class No94 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        public List<Integer> preTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        public List<Integer> afterTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        public void inorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
        public void preorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            inorder(root.left, list);
            inorder(root.right, list);
        }
        public void afterorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            inorder(root.right, list);
            list.add(root.val);
        }
    }
}
