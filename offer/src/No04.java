import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 二维数组查找元素
 * @date 2022/4/8 10:22
 **/

/**
 *  时间复杂度 O(m+n)
 */
public class No04 {
    public static class Solution {
        public static boolean Find(int target, int[][] array) {
            int row = array.length, column = array[0].length;
            int startRow = 0, startColumn = column - 1;
            while (startRow < row && startColumn >= 0) {
                if (array[startRow][startColumn] == target) return true;
                // 比 target 大 那么排除当前列 整列
                else if (array[startRow][startColumn] > target) startColumn--;
                // 比 target 小 那么排除当前行 整行
                else if (array[startRow][startColumn] < target) startRow++;
            }
            return false;
        }
    }

    @Test
    public void  test1(){
        Solution.Find(5, new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15} });
    }
}