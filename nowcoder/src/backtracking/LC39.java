package backtracking;

import org.junit.jupiter.api.Test;

import javax.management.DescriptorKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cz
 * @Description 组合总和
 * @date 2022/5/13 10:31
 **/
public class LC39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subRes = new ArrayList<>();
    int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        boolean[] visit = new boolean[n];
        Arrays.sort(candidates);
        backtrck(candidates, 0, n, target);
        return res;
    }

    public void backtrck(int[] nums, int startIndex, int n, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(subRes));
            return;
        }
        for (int i = startIndex; i < n; i++) {
            if (sum < target) {
                sum += nums[i];
                subRes.add(nums[i]);
                backtrck(nums, i, n, target);
                sum -= subRes.get(subRes.size() - 1);
                subRes.remove(subRes.size() - 1);
            }
        }
    }


    @Test
    public void test(){
        LC39 lc39 = new LC39();
        lc39.combinationSum(new int[]{2,3,6,7}, 7);
    }
}
