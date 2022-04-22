import java.util.ArrayList;

/**
 * @author cz
 * @Description 循环遍历矩阵
 * @date 2022/4/20 10:38
 **/
public class No29 {

    public class Solution {
        public ArrayList<Integer> printMatrix(int [][] matrix) {
            ArrayList<Integer> res = new ArrayList<Integer>();
//         int row = matrix.length, column = matrix[0].length;

            if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return res;
            int low = 0, high = matrix.length-1, left = 0, right = matrix[0].length-1;
            int row, column;
            while(true) {
                for(int i=left; i<=right; i++){
                    res.add(matrix[low][i]);
                }
                low++;
                if (low>high) break;
                for(int i=low; i<=high; i++){
                    res.add(matrix[i][right]);
                }
                right--;
                if (right<left) break;
                for(int i=right; i>=left; i--){
                    res.add(matrix[high][i]);
                }
                high--;
                if (high<low) break;
                for(int i=high; i>=low;i--){
                    res.add(matrix[i][left]);
                }
                left++;
                if (left>right) break;
            }
            return  res;
        }
    }

    public static void main(String[] args) {
        System.out.println(11);
    }
}
