/**
 * @author cz
 * @Description 二叉树的下一个节点
 * @date 2022/4/9 18:22
 **/
public class No08 {
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;  // 指向父节点的指针

    TreeLinkNode(int val) {
        this.val = val;
    }
}

    public class Solution {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode.right == null) {
                //为根节点情况
                if (pNode.next == null) return pNode.next;
                    // 为叶子节点的情况
                else {
                    // 为左叶子节点
                    if (pNode.next.left == pNode) return pNode.next;

                        // 为右叶子节点
                    else if (pNode.next.right == pNode) {
                        TreeLinkNode resTree = pNode;
                        // 判断 是左子树的叶子节点 还是右子树的叶子节点
                        while (resTree.next != null) {
                            if (resTree.next.left == resTree) return resTree.next;
                            resTree = resTree.next;
                        }
                        // 始终是右子树的 叶子节点 返回空
                        return resTree.next;
                    }
                }
            } else {
                TreeLinkNode temp = pNode.right;
                TreeLinkNode res = temp;
                while (temp != null) {
                    res = temp;
                    temp = temp.left;
                }
                return res;
            }
            return null;
        }
    }
}
