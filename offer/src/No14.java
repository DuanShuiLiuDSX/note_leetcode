import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 剪绳子
 * @date 2022/4/12 19:58
 **/
public class No14 {
    static class Solution {
        public static int cuttingRope(int n) {
            int[] res = new int[n+1];
            if(n==2) return 1;
            if(n==3) return 2;
            res[1]=1;
            res[2]=1;
            res[3]=2;
            for(int i=4; i<=n; i++){
                for(int j=1; j<i; j++){
                    int temp = Math.max( res[i-j]*j,  res[j]*res[i-j] );
                    res[i] = Math.max(temp, res[i]);
                }
            }
            return  res[n];
        }
    }

    /**
     *  数论解法  分成多个三  乘积最大
     *  证明如下： n>5 时 3(n-3) > 2(n-2)
     *
     */
    class Solution1 {
        public int cuttingRope(int n) {
            if(n<=3) return n-1;
            int sum=1;
            while (n>4){
                sum = sum*4;
                n = n-3;
            }
            return sum * n;
        }
    }

    @Test
    public void test(){
        Solution.cuttingRope( 10);
    }
}
