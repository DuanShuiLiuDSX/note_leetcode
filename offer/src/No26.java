import org.omg.CORBA.StringHolder;

import java.util.HashMap;

/**
 * @author cz
 * @Description 树的子结构
 * @date 2022/4/18 10:48
 **/
public class No26 {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if(B==null) return false;
            if (A==null && B!=null) return false;
            boolean flag= false;
            if (A.val == B.val){
                flag = isSubTree(A, B);
            }
            if (flag==false){
                flag = isSubStructure(A.left, B) || isSubStructure(A.right, B);
            }
            return flag;
        }

        boolean isSubTree(TreeNode a, TreeNode b){
            if (b==null) return true;
            if(b!=null && a==null) return false;
            if(a.val == b.val){
                return isSubTree(a.left, b.left) && isSubTree(a.right, b.right);
            }else {
                return  false;
            }
        }

    }
}
