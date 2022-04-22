/**
 * @author cz
 * @Description 二叉树的某一值的路径
 *  题意要求 要从 根节点到叶子节点的完整的路径
 * @date 2022/4/22 12:43
 **/
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
public class No34 {

    /**
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
     */
    public class Solution {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

            if(root==null) return result;
            target-=root.val;
            path.add(root.val);
            if(target==0 && root.left==null && root.right==null)
                // 如果result.add(path); 那么存的是path指向的对象, path变化, 存进去的值也会跟着变化
                result.add(new ArrayList<Integer>(path));
            if(root.left!=null) FindPath(root.left,target);
            if(root.right!=null) FindPath(root.right,target);
            path.remove(path.size()-1);
            return result;
        }





//     public void dfs(TreeNode root, int expectNumber, ArrayList<Integer> temp){
//         if(root==null) return;
//         if(root.val != expectNumber){
//             temp.add(root.val);
//             dfs(root.left, expectNumber-root.val, temp);
//             dfs(root.right, expectNumber-root.val, temp);
//             temp.remove(temp.size()-1);
//         }else{
//             temp.add(root.val);
//             res.add(temp);
//             dfs(root.left, 0, temp);

//             dfs(root.right, 0, temp);
//             temp.remove(temp.size()-1);
//         }

    }

    @Test
    public void test(){
        ArrayList<ArrayList<Integer>> result1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path1 = new ArrayList<Integer>();
        path1.add(1);
        result1.add(path1);
        path1.add(2);
        System.out.println(result1.get(0));
    }
}
