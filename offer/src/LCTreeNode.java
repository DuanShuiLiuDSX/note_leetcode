/**
 * @author cz
 * @Description leetcode 树结构
 *
 * @date 2022/4/11 19:19
 **/
public class LCTreeNode {
    int val;
    LCTreeNode left;
    LCTreeNode right;
    LCTreeNode() {}
    LCTreeNode(int val) { this.val = val; }
    LCTreeNode(int val, LCTreeNode left, LCTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
