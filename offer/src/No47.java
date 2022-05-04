/**
 * @author cz
 * @Description
 * @date 2022/4/27 16:17
 **/
public class No47 {
    public int maxValue (int[][] grid) {
        // write code here
        int m =grid.length, n=grid[1].length;
        int[][] res = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (i==0 && j==0)
                    res[i][j]=grid[i][j];
                else {
                    if (i>0 && j>0){
                        res[i][j] = Math.max( res[i-1][j-1]+res[i-1][j], res[i-1][j-1]+res[i][j-1]) + grid[i][j];
                    }else if (i==0){
                        res[i][j] = res[i][j-1] + grid[i][j];
                    }else if (j==0){
                        res[i][j] = res[i-1][j] + grid[i][j];
                    }
                }
            }
        }
        return res[m-1][n-1];
    }
}
