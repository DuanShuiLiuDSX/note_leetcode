package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cz
 * @Description 组合问题
 * @date 2022/5/16 9:37
 **/
public class LC70 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subRes = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backstrack(n, k, 1);
        return res;
    }

    public void backstrack(int n, int k, int startIndex){
        if(subRes.size()==k){
            res.add(new ArrayList<>(subRes));
            return;
        }
        for(int i=startIndex; i<=n; i++ ){
            if(n-i+1+subRes.size() < k) break;
            subRes.add(i);
            backstrack(n,k,i+1);
            subRes.remove(subRes.size()-1);
        }
    }
}
