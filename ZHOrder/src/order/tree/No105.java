package order.tree;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cz
 * @Description 从前序遍历、中序遍历构建二叉树
 * @date 2022/2/26 9:15
 **/

public class No105 {
    class Solution {
        /**
         *   前序  [ [根] [左子树] [右子树] ]
         *   中序  [ [左子树] [根] [右子树] ]
         *   判断是否有左子树
         *   preorder[preStart] == inorder[inStart])  说明没有左子树
         *   preorder[preStart] == inorder[inEnd]     说明没有右子树
         */

        private Map<Integer, Integer> indexMap;

        private TreeNode myBuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
            if(preStart == preEnd){
                return new TreeNode(preorder[preStart]);
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            if(preorder[preStart] != inorder[inStart]){        //有左子树
                int left = indexMap.get(root.val) - 1; //左子树在inorder中的范围是[inStart, left]
                int leftNum = left - inStart + 1; //左子树的节点个数 从根节点pre数组往右开始寻找，preorder中的范围是[preStart+1, presatrt+leftNum]
                root.left = myBuildTree(preorder, preStart+1, preStart+leftNum, inorder, inStart, left);

            }
            // preorder[preStart] 每层递归的根节点 等于 inorder[inEnd] 说明 inorder[0, inEnd-1]都是左子树
            if(preorder[preStart] != inorder[inEnd]){      //有右子树
                int right = indexMap.get(root.val) + 1;   //根节点的右边  右子树在inorder中的范围是[right, inEnd]
                int rightNum = inEnd - right + 1;//右子树的节点个数 从pre数组末尾开始寻找，它在preorder中范围是[preEnd-rightNum+1, preEnd]
                root.right = myBuildTree(preorder, preEnd - rightNum + 1, preEnd, inorder, right, inEnd);
            }
            return root;
        }


        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, 0, n - 1, inorder, 0, n - 1);
        }
    }


}
