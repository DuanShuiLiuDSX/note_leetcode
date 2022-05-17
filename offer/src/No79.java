/**
 * @author cz
 * @Description
 * @date 2022/5/9 10:20
 **/
public class No79 {
    public class Solution {
        public boolean IsBalanced_Solution(TreeNode root) {
            return getHeight(root) >= 0;
        }

        public int getHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int heightLeft = getHeight(node.left);
            if (heightLeft == -1) {
                return -1;
            }
            int heightRight = getHeight(node.right);
            if (heightRight == -1) {
                return -1;
            }
            if (Math.abs(heightLeft - heightRight) > 1) {
                return -1;
            }

            return Math.max(heightLeft, heightRight) + 1;
        }
    }
}
