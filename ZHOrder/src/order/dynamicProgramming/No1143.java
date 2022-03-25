package order.dynamicProgramming;

/**
 * @author cz
 * @Description 最长公共子序列
 * @date 2022/3/11 9:53
 **/
public class No1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        if (text1.length() == 0)return -1;
        if (text2.length() == 0)return -1;
        for (int i=1; i<=text1.length(); i++){
            char c1 = text1.charAt(i-1);
            for (int j=1; j<=text2.length(); j++){
                char c2 = text2.charAt(j-1);
                if (c1 == c2){
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+1;
                    // 在前一个子序列上加1
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
