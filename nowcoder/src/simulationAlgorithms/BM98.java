package simulationAlgorithms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
/**
 * @author cz
 * @Description 螺旋数组
 * @date 2022/3/12 14:56
 **/
public class BM98 {
    public static class Solution {
        public static ArrayList<Integer> spiralOrder(int[][] matrix) {
            int startX = 0, startY = 0, len1 = matrix.length, len2 = matrix[0].length;
            if (len1 == 0) return null;
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (int i = startX; i < len1; i++) {
                for (int j = startY; j < len2; j++) {
                    arrayList.add(matrix[startX][j]);
                }
                for (int j = startX + 1; j < len1; j++) {
                    arrayList.add(matrix[j][len2 - 1]);
                }
                if (startX<len1 && startY<len2){
                    for (int j = len2 - 2; j >= startY; j--) {
                        arrayList.add(matrix[len1 - 1][j]);
                    }
                    for (int j = len1 - 2; j >= startX + 1; j--) {
                        arrayList.add(matrix[j][startY]);
                    }
                }

                len1 -= 1;
                len2 -= 1;
                startX += 1;
                startY += 1;
            }
            return arrayList;
        }


    }

    @Test
    public void test() {
        System.out.println(Solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(Solution.spiralOrder(new int[][]{{}}));
        System.out.println(Solution.spiralOrder(new int[][]{{2,3}}));
    }

    public static class Solution1 {
        public ArrayList<Integer> spiralOrder(int[][] matrix) {
            ArrayList<Integer> res = new ArrayList<>();
            if (matrix.length == 0) return res;
            int top = 0, left = 0, right = matrix[0].length - 1, bot = matrix.length - 1;
            while (left <= right && top <= bot) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                for (int i = top + 1; i <= bot; i++) {
                    res.add(matrix[i][right]);
                }
                if (top < bot && left < right) {
                    for (int i = right - 1; i >= left; i--) {
                        res.add(matrix[bot][i]);
                    }
                    for (int i = bot - 1; i >= top + 1; i--) {
                        res.add(matrix[i][left]);
                    }
                }
                left++;
                right--;
                top++;
                bot--;
            }
            return res;
        }
    }
}