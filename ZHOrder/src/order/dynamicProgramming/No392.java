package order.dynamicProgramming;

/**
 * @author cz
 * @Description 判断子序列
 * @date 2022/3/11 10:15
 **/
public class No392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.length()==0)return false;
            if(t.length()==0)return false;
            int[][] dp = new int[s.length()+1][t.length()+1];
            for(int i=1; i<=s.length(); i++){
                char s1 = s.charAt(i-1);
                for(int j=1; j<=t.length(); j++){
                    char t1 = t.charAt(j-1);
                    if(s1 == t1){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            if(dp[s.length()][t.length()]==0) return false;
            return true;
        }
    }
}
