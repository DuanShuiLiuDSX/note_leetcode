package order.tree;

import com.sun.xml.internal.ws.api.message.MessageWritable;
import order.linkedList.Test;

import java.util.*;

/**
 * @author cz
 * @Description 层序遍历
 * @date 2022/2/25 12:44
 **/
public class No102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (queue.isEmpty()==false){
                List<Integer> list = new ArrayList<Integer>();
                int length = queue.size();
                for (int i = 0; i < length; i++) {
                    TreeNode temp = queue.poll();
                    list.add(temp.val);
                    if (temp.left!=null)
                        queue.add(temp.left);
                    if (temp.right!=null)
                        queue.add(temp.right);
                }
                result.add(list);
            }
            return result;
        }
    }
}
