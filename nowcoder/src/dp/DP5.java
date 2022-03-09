package dp;

import java.util.Scanner;

/**
 * @author cz
 * @Description 二叉搜索树
 * @date 2022/3/9 10:20
 **/
public class DP5 {
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2; i<=n; i++){
            for (int j=1; j<=i; j++){
                dp[i] +=dp[j-1] * dp[i-j];
            }

        }
        System.out.println(dp[n]);
    }
}
