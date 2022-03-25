package simulationAlgorithms;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 旋转数组
 * @date 2022/3/15 9:13
 **/
public class BM97 {
    public static class Solution {
        /**
         * 旋转数组
         * @param n int整型 数组长度
         * @param m int整型 右移距离
         * @param a int整型一维数组 给定数组
         * @return int整型一维数组
         */
        public static int[] solve (int n, int m, int[] a) {
            // write code here
            m =  m % n;
            reverse(0, a.length-1, a);
            reverse(0, m-1, a);
            reverse(m, a.length-1, a);
            return a;
        }

        public static void reverse(int left, int right, int[] a){
            while (left < right){
                int temp = a[left];
                a[left++] = a[right];
                a[right--] = temp;
            }
        }
    }

//    @Test
//    public void test(){
//        int[] a = Solution.solve(6, 2, new int[]{1,2,3,4,5,6});
//        for ( int every: a) {
//            System.out.println(every);
//        }
//    }
}
