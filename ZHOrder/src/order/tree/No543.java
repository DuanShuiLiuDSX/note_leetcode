package order.tree;

/**
 * @author cz
 * @Description 二叉树的直径
 * 二叉树的左子树最大深度+右子树的最大深度
 *
 * @date 2022/2/28 8:36
 **/
public class No543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null)
            return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return leftDepth+rightDepth;
    }

    public int depth(TreeNode treeNode){
        int depth = 0;
        if (treeNode==null)
            return depth;
        int leftDepth = depth(treeNode.left);
        int rightDepth = depth(treeNode.right);
        return (leftDepth>rightDepth)? leftDepth+1:rightDepth+1;
    }
}
