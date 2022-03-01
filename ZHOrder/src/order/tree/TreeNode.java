package order.tree;

/**
 * @author cz
 * @Description
 * @date 2022/2/25 9:50
 **/
public class TreeNode {
    TreeNode left;
    Integer val;
    TreeNode right;

    TreeNode(){
    }

    TreeNode(int value){
        this.val = value;
    }

    public TreeNode(TreeNode left, Integer value, TreeNode right) {
        this.left = left;
        this.val = value;
        this.right = right;
    }
}
