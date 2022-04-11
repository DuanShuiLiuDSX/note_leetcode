package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cz
 * @Description 前序遍历
 * @date 2022/4/6 9:17
 **/
public class BM23 {
    List<Integer> list = new ArrayList<>();

    public int[] preorderTraversal (TreeNode root) {
        List<Integer> list = preOrder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    List<Integer> preOrder(TreeNode node) {
        if (node == null) {
            return list;
        }
        list.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
        return list;
    }
}
