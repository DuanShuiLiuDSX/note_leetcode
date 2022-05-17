import java.util.ArrayList;

/**
 * @author cz
 * @Description 二叉搜索树的第k个节点
 * @date 2022/5/9 9:49
 **/
public class No54 {
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param proot TreeNode类
         * @param k int整型
         * @return int整型
         */
        ArrayList<TreeNode> arrayPre = new ArrayList<TreeNode>();

        public int KthNode (TreeNode proot, int k) {
            // write code here
            if(proot==null || k==0) return -1;
            inOrder(proot);
            if(k>arrayPre.size()) return -1;
            return arrayPre.get(k-1).val;

        }

        public void inOrder(TreeNode root){
            if(root==null)
                return;
            inOrder(root.left);
            arrayPre.add(root);
            inOrder(root.right);

        }
    }
}
