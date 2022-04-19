/**
 * @author cz
 * @Description 二进制中一的个数
 * @date 2022/4/15 9:58
 **/
public class No15 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                if ( (n & (1<<i)) !=0)
                    res++;
            }
            return res;
        }
    }
}
