/**
 * @author cz
 * @Description Fibonacci
 * @date 2022/4/9 19:36
 **/
public class No10 {
    /**
     * 递归的问题 要多次计算 前面的值
     */
    public class Solution {
        public int Fibonacci(int n) {
            if(n==1)return 1;
            if(n==2)return 1;
            int res1=1, res2=1;
            for(int i=2; i<n; i++){
                int temp=res1;
                res1=res2;
                res2 = temp+res1
                ;
            }
            return  res2;
        }
    }
}
