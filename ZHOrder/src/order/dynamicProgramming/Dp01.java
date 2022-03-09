package order.dynamicProgramming;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Scanner;

/**
 * @author cz
 * @Description
 * @date 2022/3/5 19:00
 **/
public class Dp01 {
    public static void main(String[] args) {
        int res = solution(4);
        System.out.println(solution(4));
    }

    public static int solution(int length){
        int[] products = new int[length+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;
        int max = 0;
        for (int i=4; i<=length; i++){
            max=0;
            for (int j=1; j<=i/2; ++j){
                int product = products[j] * products[i-j];
                if (max < product){
                    max=product;
                }
                products[i]=max;
            }
        }
        max =products[length];
        return max;
    }
}