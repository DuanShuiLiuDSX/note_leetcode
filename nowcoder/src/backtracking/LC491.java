package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cz
 * @Description 递增子序列
 * @date 2022/5/17 20:44
 **/
public class LC491 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subRes = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        int n= nums.length;
        backStrack(nums, n, 0);
        return res;
    }

    public void backStrack(int[] nums,int n, int startIndex){
        if(subRes.size()>=2){
            res.add(new ArrayList(subRes));
        }
        // for 循环 树的横向
        // backStrack 树的纵向
        int[] used=new int[201];
        for(int i=startIndex; i<n; i++){
            if (!subRes.isEmpty() && nums[i] < subRes.get(subRes.size() - 1) || used[nums[i] + 100] == 1)
                continue;
            used[nums[i] + 100] = 1;
            subRes.add(nums[i]);
            backStrack(nums,  n, i + 1);
            subRes.remove(subRes.size() - 1);
        }
    }



    public static void main(String[] args) {
        LC491 lc491 = new LC491();
        lc491.findSubsequences(new int[]{-100,-99,-98});
    }
}
