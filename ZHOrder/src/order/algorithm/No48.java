package order.algorithm;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 旋转图像
 * @date 2022/3/1 9:00
 **/
public class No48 {
    /**
     *  开辟新的二维数组
     */
    static class Solution1 {
        public static void rotate(int[][] matrix) {
            int[][] newMatrix = new int[matrix.length][matrix.length];
            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    newMatrix[j][matrix.length-i-1] = matrix[i][j];
                }
            }

            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.println(newMatrix[i][j]);
                }
            }
        }
    }

    /**
     *  原地旋转解法  只有O(1)的空间复杂度
     */
    static class Solution {
        public static void rotate(int[][] matrix) {
            int len = matrix.length;

            // 根据奇、偶数来确定循环次数
            for (int i = 0; i < len/2; i++) {
                for (int j=0; j< (len+1)/2; j++){
                    // 四个位置循环交换
                    int t = matrix[j][len-i-1];
                    matrix[j][len-i-1] = matrix[i][j];
                    matrix[i][j] = matrix[len-j-1][i];
                    matrix[len-j-1][i] = matrix[len-i-1][len-j-1];
                    matrix[len-i-1][len-j-1] = t;
                }
            }
        }
    }


    @Test
    public void test(){
        int[][] a = new int[][]{{1,2}, {1,2,3,4},{1,2,3,4,5}};
        System.out.println(a[2].length);  //5
        System.out.println(a.length);  //3

    }

    @Test
    public void test1(){
        Solution1.rotate(new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}});
    }


}
