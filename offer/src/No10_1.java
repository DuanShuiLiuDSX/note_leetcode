/**
 * @author cz
 * @Description 青蛙过台阶
 * @date 2022/4/11 9:17
 **/
public class No10_1 {
    class Solution {
        public int numWays(int n) {
            if(n==1 || n==0) return 1;
            if(n==2) return 2;
            int res=0;
            int temp1=1, temp2=2;
            for(int i=2; i<n; i++){
                res = (temp1+temp2) %1000000007;
                temp1=temp2;
                temp2=res;
            }
            return res;
        }
    }
}
