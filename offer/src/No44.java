/**
 * @author cz
 * @Description 数字序列中的某一位
 * @date 2022/4/25 10:42
 **/
public class No44 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return int整型
     */
    public int findNthDigit (int n) {
        if (n==0) return n;
        int length=1, i=1;
        while(n > 9*length*Math.pow(10, i-1)){
            n -= (9*length*Math.pow(10, i-1));
            i++;
            length++;
        }
        int res = 0;
        int balance = n % i;
        if(balance==0){
            res = (int)( Math.pow(10, i-1)+ n/i -1);
        }else{
            res = (int) ( Math.pow(10, i-1) + n/i);
        }
        String s = String.valueOf(res);
        char[] chars = s.toCharArray();
        return balance==0 ? chars[chars.length-1]-'0' :chars[balance-1]-'0';
    }

}

class Test{
    public static void main(String[] args) {
        No44 no44 = new No44();
        int nthDigit = no44.findNthDigit(10000);
        System.out.println(nthDigit);
    }
}