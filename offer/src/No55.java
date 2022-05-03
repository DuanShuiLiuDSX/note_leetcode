import java.util.ArrayList;
import java.util.Stack;

/**
 * @author cz
 * @Description 二叉树的深度
 * @date 2022/5/3 9:31
 **/
public class No55 {
    //  空间O(n) 栈
    public class Solution1 {
        public int TreeDepth(TreeNode root) {
            ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
            if (root==null) return 0;
            int res=0;
            stack.add(root);
            while (stack.isEmpty()==false){
                int size = stack.size();
                for (int i=0; i<size; i++){
                    TreeNode temp = stack.get(i);
                    if (temp.left!=null) stack.add(temp.left);
                    if (temp.right!=null) stack.add(temp.right);
                    stack.remove(0);
                }
                res++;
            }
            return  res;
        }

        public int dfs(TreeNode root){
            if (root==null)return 0;
            int nLeft = dfs(root.left);
            int nRight = dfs(root.right);
            return nLeft > nRight ? nLeft+1 : nRight+1;
        }
    }
}
