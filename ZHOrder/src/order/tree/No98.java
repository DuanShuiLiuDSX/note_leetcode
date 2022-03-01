package order.tree;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cz
 * @Description 验证二叉搜索树
 * @date 2022/2/28 10:07
 **/
public class No98 {

    public  static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public  static boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(null,7,null);
        TreeNode t2 = new TreeNode(null,1,t1);
        TreeNode t3 = new TreeNode(null,3,null);
        TreeNode t4 = new TreeNode(null,6,null);
        TreeNode t5 = new TreeNode(t3,4,t4);
        TreeNode t6 = new TreeNode(t2,5,t5);
        boolean res = No98.isValidBST(t6);
    }

    // 中序遍历  中序遍历的有效二叉树为 递增的序列
    public static boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    @Test
    public void test1(){
        TreeNode t1 = new TreeNode(null,7,null);
        TreeNode t2 = new TreeNode(null,1,t1);
        TreeNode t3 = new TreeNode(null,3,null);
        TreeNode t4 = new TreeNode(null,6,null);
        TreeNode t5 = new TreeNode(t3,4,t4);
        TreeNode t6 = new TreeNode(t2,5,t5);
        boolean res = No98.isValidBST1(t6);
    }

    // 中序遍历  中序遍历的有效二叉树为 递增的序列
    public  boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        double inorder = -Double.MAX_VALUE;
        //while 循环 实现中序遍历
        while (stack.isEmpty()==false || root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
//            if (root.val<inorder)
//                return false;
//            inorder = root.val;
            root = root.right;
        }
        return true;
    }


}
