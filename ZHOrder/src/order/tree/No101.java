package order.tree;

/**
 * @author cz
 * @Description 对称二叉树
 * @date 2022/2/25 10:46
 **/
public class No101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root.left==null && root.right==null)
                return true;
            return compare(root.left, root.right);
        }

        public boolean compare(TreeNode left, TreeNode right){
            if (left==null && right==null){
                return true;
            }
            if (left==null || right==null){
                return false;
            }
            if (left.val!= right.val){
                return false;
            }
            boolean leftCompare = compare(left.left, right.right);
            boolean rightCompare = compare(left.right, right.left);
            return leftCompare && rightCompare;
        }
    }
}
