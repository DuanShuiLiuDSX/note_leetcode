package order.dynamicProgramming;

/**
 * @author cz
 * @Description 爬楼梯
 * @date 2022/3/6 10:59
 **/
public class No70 {
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            dp[0] =1;
            dp[1] =1;
            dp[2] =2;
            for (int i=2; i<=n; i++){
                dp[i] = dp[i-1]+dp[i-2];
            }
            return dp[n-1];
        }
    }
}
