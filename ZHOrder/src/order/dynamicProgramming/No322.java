package order.dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author cz
 * @Description 零钱找零
 * @date 2022/3/8 13:05
 **/
public class No322 {
    static class  Solution {
        public static int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        // 每次增加一块钱  （dp[i - coins[j]] + 1）---> 从硬币数组中取出一个 然后得到余额所需的最小的个数 +1
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];

        }


    }

    @Test
    public void test(){
        No322.Solution.coinChange(new int[]{1,2,4,5}, 11);
    }
}
