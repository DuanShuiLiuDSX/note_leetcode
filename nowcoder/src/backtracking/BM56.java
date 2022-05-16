package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cz
 * @Description   带有重复数字的全排列
 * @date 2022/5/13 9:34
 **/
public class BM56 {
    public class Solution {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> subRes = new ArrayList<>();
        public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
            Arrays.sort(num);
            int n = num.length;
            backstrack(num, new boolean[n], n);
            return res;
        }

        public void backstrack(int[] num, boolean[] visit, int n){
            if(subRes.size()==n){
                res.add(new ArrayList<>(subRes));
                return;
            }
            for(int i=0; i<n; i++){
                if(!visit[i]){
                    // 回溯回来时， 当当前位置的元素和 和前一个元素相同时 且 前一个元素已经被访问了又重新从subRes释放（即前一个元素在subRes中）
                    if(i>0 && num[i]==num[i-1] && !visit[i-1] ){
                        continue;
                    }
                    subRes.add(num[i]);
                    visit[i]=true;
                    backstrack(num, visit, n);
                    visit[i]=false;
                    subRes.remove(subRes.size()-1);
                }
            }
        }
    }
}
