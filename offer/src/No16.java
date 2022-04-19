/**
 * @author cz
 * @Description 整数的n次方
 * @date 2022/4/15 10:19
 **/
public class No16 {
    public class Solution {
        public double Power(double base, int exponent) {
            double res = 1.0;
            if(base==0) return 0;
            if(exponent==0) return 1;
            if(exponent>0){
                for(int i=0; i<exponent; i++){
                    res *= base;
                }
            }else{
                for(int i=0; i<exponent; i++){
                    res *= base;
                }
                res = 1.0/res;
            }

            return res;

        }

    }
}
