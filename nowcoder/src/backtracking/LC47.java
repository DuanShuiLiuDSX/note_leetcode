package backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author cz
 * @Description 重复数字, 结果不能重复的全排列
 * @date 2022/5/15 19:46
 **/
public class LC47 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> subRes = new ArrayDeque<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] visits = new boolean[n];
        backstrack1(nums, visits, 0, n);
        return res;
    }

    private void backstrack(int[] nums,boolean[] visits, int n){
        if (subRes.size()==n){
            res.add(new ArrayList<>(subRes));
            return;
        }
        for (int i=0; i<n; i++){
            if (!visits[i]){
                if (i>0 && visits[i-1]==false && nums[i]==nums[i-1])
                    continue;
                subRes.add(nums[i]);
                visits[i]=true;
                backstrack(nums, visits, n);
                visits[i]=false;
                subRes.removeLast();
            }
        }
    }

    /**
     *       带起始位置写法
     * @param nums
     * @param visits
     * @param start
     * @param n
     */
    private void backstrack1(int[] nums,boolean[] visits,int start, int n){
        if (subRes.size()==n){
            res.add(new ArrayList<>(subRes));
            return;
        }
        for (int i=start; i<n; i++){
            if (!visits[i]){
                if (i>start && visits[i-1]==false && nums[i]==nums[i-1])
                    continue;
                subRes.add(nums[i]);
                visits[i]=true;
                backstrack1(nums, visits, start ,n);
                visits[i]=false;
                subRes.removeLast();
            }
        }
    }

    @Test
    public void test(){
        LC47 lc47 = new LC47();
        lc47.permuteUnique(new int[]{1,1,2});
    }
}
