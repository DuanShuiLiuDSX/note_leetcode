package order.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cz
 * @Description 二叉树展成链表
 * @date 2022/2/27 19:55
 **/
public class No114 {
    public Queue<TreeNode> queue =new ArrayDeque<TreeNode>();
    public void flatten(TreeNode root) {
        if (root==null)
            return;
        preorder(root);
        int size =queue.size();
        for (int i = 1; i <size ; i++) {
            TreeNode pre = queue.poll();
            TreeNode cur = queue.peek();
            pre.left=null;
            pre.right=cur;
        }

    }

    public void preorder(TreeNode root){
        if (root==null)
            return;
        queue.add(root);
        preorder(root.left);
        preorder(root.right);
    }

}
