import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cz
 * @Description
 * @date 2022/5/7 19:12
 **/
public class No77 {
    public class Solution {
        public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(pRoot);
            int flag=1;
            while(queue.isEmpty()==false){
                if(flag%2==0){
                    int length = queue.size();
                    ArrayList<Integer> subRes = new ArrayList<Integer>();
                    for(int i=0; i<length; i++){
                        TreeNode temp = queue.poll();
                        subRes.add(temp.val);
                        if(temp.left!=null) queue.add(temp.left);
                        if(temp.right!=null) queue.add(temp.right);
                    }
                    flag++;
                    reOrder(subRes);
                    res.add(subRes);
                }else{
                    int length = queue.size();
                    ArrayList<Integer> subRes = new ArrayList<Integer>();
                    for(int i=0; i<length; i++){
                        TreeNode temp = queue.poll();
                        subRes.add(temp.val);
                        if(temp.left!=null) queue.add(temp.left);
                        if(temp.right!=null) queue.add(temp.right);
                    }
                    flag++;
                    res.add(subRes);
                }
            }
            return res;
        }

        public void reOrder(ArrayList<Integer> subRes){
            int left=0, right = subRes.size()-1;
            while(left < right ){
                int temp = subRes.get(left);
                subRes.set(left, subRes.get(right));
                subRes.set(right, temp);
                left++;
                right--;
            }
        }
    }


}
