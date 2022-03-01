package order.tree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cz
 * @Description 二叉树最大深度
 * @date 2022/2/25 13:49
 **/
public class No104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            int res=0;
            if (root==null)
                return res;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (queue.isEmpty()==false){
                int length = queue.size();
                for (int i = 0; i < length; i++) {
                    TreeNode temp = queue.poll();
                    if (temp.left!=null)
                        queue.add(temp.left);
                    if (temp.right!=null)
                        queue.add(temp.right);
                }
                res++;
            }
            return res;
        }
    }

    @Test
    public void queueTest(){
        Queue queue = new LinkedList();
        queue.add(null);
        System.out.println(queue.size());
    }

//    递归解法
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if(root==null)
                return 0;
            int numLeft = maxDepth(root.left);
            int numRight = maxDepth(root.right);
            return (numLeft>numRight) ? numLeft+1 : numRight+1;
        }
    }
}
