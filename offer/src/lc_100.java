/**
 * @author cz
 * @Description  两颗树是否相同
 * @date 2022/4/11 19:17
 **/
public class lc_100 {
    class Solution {
        public boolean isSameTree(LCTreeNode p, LCTreeNode q) {
            if(p==null && q== null) return true;
            if(p==null || q==null) return false;
            if (p.val==q.val && q.left==p.left &&  q.right==q.right)
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

            return false;
        }
    }
}


