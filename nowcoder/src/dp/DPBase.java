package dp;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 01背包问题
 *   https://blog.csdn.net/wmy01234/article/details/105622517
 * @date 2022/3/10 10:09
 **/
public class DPBase {
    static class Solution{
        public static int bestChoice(int[] weight, int[] value, int C){
            int[][] dp = new int[value.length+1][C+1];
            for (int i=1; i<=weight.length; i++){
                for (int r=1; r<=C; r++){
                    dp[i][r] = dp[i-1][r];
                    if (r>=weight[i-1]){
                        dp[i][r] = Math.max(dp[i-1][r], dp[i-1][r-weight[i-1]] + value[i-1]);
                    }
                }
            }
            for (int i=0; i< dp.length; i++){
                for (int j=0; j<dp[0].length; j++){
                    System.out.print(dp[i][j]);
                }
                System.out.println();
            }
            return dp[value.length][C];
        }
    }

    @Test
    public void test(){
        System.out.println(Solution.bestChoice(new int[]{3,4,7,8,9}, new int[]{4,5,10,11,13}, 17));
    }
}
