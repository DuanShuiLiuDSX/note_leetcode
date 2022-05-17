package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cz
 * @Description 组合题
 * @date 2022/5/16 9:53
 **/
public class LC216 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            backstrack(k, n, 1);
            return res;
        }

        public void backstrack(int k, int n, int startIndex){
            if(subRes.size()==k && n==0){
                res.add(new ArrayList<>(subRes));
                return;
            }
            for(int i=startIndex; i<=9; i++){
                if(n<0) break;
                subRes.add(i);
                n-=i;
                backstrack(k,n, i+1);
                n+=subRes.get(subRes.size()-1);
                subRes.remove(subRes.size()-1);
            }
        }
    }
}
