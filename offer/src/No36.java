import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author cz
 * @Description 二叉搜索树转为双向链表
 * @date 2022/4/22 13:20
 **/
public class No36 {
    /**
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
     */

    public class Solution {
        TreeNode head, pre;
        public TreeNode Convert(TreeNode root) {
           if (root==null) return null;
           inOrder(root);
            pre.right = head;
            head.left =pre;//进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
            return head;
        }
        public void inOrder(TreeNode cur){
            if (cur==null) return;
            inOrder(cur.left);

            //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
            if(pre==null) head = cur;
                //反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
            else pre.right = cur;

            cur.left = pre;//pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。

            pre = cur;//pre指向当前的cur
            inOrder(cur.right);//全部迭代完成后，pre指向双向链表中的尾节点

        }
    }



}
