import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cz
 * @Description 层序遍历二叉树
 * @date 2022/4/21 19:04
 **/
public class No32 {
    /**
     *  根节点以此入队  出队 进行层序遍历
     */
    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            ArrayList<Integer> res = new ArrayList<>();
            if (root==null) return res;
            queue.add(root);
            while (queue.isEmpty()==false){
                TreeNode temp = queue.poll();
                res.add(temp.val);
                if (temp.left!=null) queue.add(temp.left);
                if (temp.right!=null) queue.add(temp.right);
            }
            return res;
        }
    }
}
