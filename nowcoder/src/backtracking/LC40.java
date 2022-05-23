package backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cz
 * @Description
 * @date 2022/5/15 18:35
 **/
public class LC40 {
    List<Integer> subRes = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        boolean[] visit = new boolean[n];
        backstrack(candidates, visit, 0, target, n);
        return res;
    }

    private void backstrack(int[] candidates, boolean[] visit, int startIndex, int target, int n){
        if (target==0) {
            res.add(new ArrayList<>(subRes));
            return;
        }
        for (int i=startIndex; i<n; i++){
            if (target<0) break;

            // 剪枝 分析两种情况
            /**  {1,1,2}  target =2 的情况
             * 第一个 backstrack 进去时 会得到 {1,2};
             * 然后 回到第一个的for循环, i+1, 找到第二个 1 (先执行完所有的递归 backstrack 才会i++)
             * 此时已经存储完一遍结果了, 所以判断的条件是 i>startIndex
             *
             */
            if (i > startIndex && candidates[i]==candidates[i-1])
                continue;
            if (!visit[i]){
                    subRes.add(candidates[i]);
                    visit[i] = true;
                    backstrack(candidates, visit, i + 1, target - candidates[i], n);
                    visit[i] = false;
                    subRes.remove(subRes.size() - 1);
            }
        }
    }

    @Test
    public void test(){
        LC40 test = new LC40();
        test.combinationSum2(new int[]{1,1,2}, 3);
    }


}
