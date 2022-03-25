package simulationAlgorithms;

/**
 * @author cz
 * @Description 顺时针旋转数组
 * @date 2022/3/15 10:40
 **/
public class BM99 {
    public class Solution {
        public int[][] rotateMatrix(int[][] mat, int n) {
            // write code here
            if (n%2==0){
                for (int i=0; i< n/2; i++){
                    for (int j=0; j<n/2; j++){
                        int temp = mat[i][j];
                        mat[i][j] = mat[n-j-1][i];
                        mat[n-j-1][i] = mat[n-i-1][n-j-1];
                        mat[n-i-1][n-j-1] = mat[j][n-i-1];
                        mat[j][n-i-1] = temp;
                    }
                }
            }else {
                for (int i=0; i< n/2; i++){
                    for (int j=0; j<=n/2; j++){
                        int temp = mat[i][j];
                        mat[i][j] = mat[n-j-1][i];
                        mat[n-j-1][i] = mat[n-i-1][n-j-1];
                        mat[n-i-1][n-j-1] = mat[j][n-i-1];
                        mat[j][n-i-1] = temp;
                    }
                }
            }

            return mat;
        }
    }
}
