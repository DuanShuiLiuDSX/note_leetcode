package order.dynamicProgramming;

/**
 * @author cz
 * @Description 不同的二叉搜索树
 * @date 2022/3/9 10:12
 **/
public class No96 {
    class Solution{
        public int numTrees(int n){
            int[] dp = new int[n+1];
            dp[0]=1;
            dp[1]=1;
            //每次选择 第 j 个节点作为根节点时， current二叉搜索树的个数为 左子树的个数 * 右子树的个数
            for (int i = 2; i <=n ; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] +=dp[j-1] * dp[i-j];
                }
            }
            return dp[n];
        }
    }
}
