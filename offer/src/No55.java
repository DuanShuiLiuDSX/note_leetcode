/**
 * @author cz
 * @Description 求二叉树深度
 *   递归解法
 * @date 2022/5/9 10:10
 **/
public class No55 {
    public class Solution {
        public int TreeDepth(TreeNode root) {
            if(root==null) return 0;
            int leftDepth = TreeDepth(root.left);
            int rightDepth = TreeDepth(root.right);
            return leftDepth>rightDepth ? leftDepth+1 : rightDepth+1;
        }
    }
}
