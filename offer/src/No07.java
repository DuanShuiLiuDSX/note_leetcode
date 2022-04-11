import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cz
 * @Description 重建二叉树
 * @date 2022/4/8 19:37
 **/
public class No07 {
    static class  Solution {
        private static Map<Integer, Integer> indexMap;



        public static TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，快速定位根节点
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }

        public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) {
                return null;
            }

            // 前序遍历中的第一个节点就是根节点
            int preorder_root = preorder_left;
            // 在中序遍历中定位根节点
            int inorder_root = indexMap.get(preorder[preorder_root]);

            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorder_root]);
            // 得到左子树中的节点数目
            int size_left_subtree = inorder_root - inorder_left;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
            return root;
        }



        public TreeNode buildTree1(int[] preorder, int[] inorder) {
            return null;
        }
    }


    /**
     *  精简版
     */
    class Solution1 {
        HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历
        int[] preorder;//保留的先序遍历，方便递归时依据索引查看先序遍历的值

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            //将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            //三个索引分别为
            //当前根的的索引
            //递归树的左边界，即数组左边界
            //递归树的右边界，即数组右边界
            return recur(0,0,inorder.length-1);
        }

        TreeNode recur(int pre_root, int in_left, int in_right){
            if(in_left > in_right) return null;// 相等的话就是自己
            TreeNode root = new TreeNode(preorder[pre_root]);//获取root节点
            int idx = map.get(preorder[pre_root]);//获取在中序遍历中根节点所在索引，以方便获取左子树的数量
            //左子树的根的索引为先序中的根节点+1
            //递归左子树的左边界为原来的中序in_left
            //递归左子树的右边界为中序中的根节点索引-1
            root.left = recur(pre_root+1, in_left, idx-1);
            //右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
            //递归右子树的左边界为中序中当前根节点+1
            //递归右子树的右边界为中序中原来右子树的边界
            root.right = recur(pre_root + (idx - in_left) + 1, idx+1, in_right);
            return root;

        }

    }


    @Test
    public void test(){
        Solution.buildTree(new int[]{3, 9 ,4}, new int[]{4,9,3});
    }

}
