package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cz
 * @Description  求子集
 * @date 2022/5/17 10:40
 **/
public class LC78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subRes = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(subRes);
        int n = nums.length;
        backstrack(nums, n, 0);
        return res;
    }

    public void backstrack(int[] nums, int n, int startIndex){
        if(subRes.size()>0){
            res.add(new ArrayList<>(subRes));
            if(nums[n-1] == subRes.get(subRes.size()-1))
                return;
        }

        for(int i=startIndex; i<n; i++){
            subRes.add(nums[i]);
            backstrack(nums, n, i+1);
            subRes.remove(subRes.size()-1);
        }
    }

    /**
     *  解法二
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = result.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }
}
