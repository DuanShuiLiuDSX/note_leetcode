import com.sun.rowset.internal.Row;
import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 机器人的活动范围
 * @date 2022/4/12 10:59
 **/
public class No13 {
    public static class Solution {
        static int res = 0;

        public static int movingCount(int threshold, int rows, int cols) {
            char[][] chars = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    dfs(chars, i, j, threshold);
                }
            }
            return res;
        }

        public static void dfs(char[][] chars, int row, int column, int threshold) {
            if (row < 0 || row >= chars.length || column < 0 || column >= chars[0].length || chars[row][column] == 'y')
                return;

            int countRow = 0, countColumn = 0, count = 0;
            countRow = row / 10 + row % 10;
            countColumn = column / 10 + column % 10;
            count = countRow + countColumn;
            if (count > threshold) {
                return;
            } else if (count <= threshold) {
                if (count == 0) {
                    res++;
                    chars[row][column] = 'y';
                } else if (count <= threshold) {
                    if(count==0){
                        res++; chars[row][column]='y';
                    }else {
                        if (count == 0) {
                            res++;
                            chars[row][column] = 'y';
                        } else if ((row - 1 >= 0 && chars[row - 1][column] == 'y') || (row + 1 <= chars.length - 1 && chars[row + 1][column] == 'y') ||
                                (column - 1 >= 0 && chars[row][column - 1] == 'y') || (column + 1 <= chars[0].length - 1 && chars[row][column + 1] == 'y')) {
                            res++;
                            chars[row][column] = 'y';
                        } else {
                            return;
                        }
                    }

                }

                dfs(chars, row + 1, column, threshold);
                dfs(chars, row - 1, column, threshold);
                dfs(chars, row, column + 1, threshold);
                dfs(chars, row, column - 1, threshold);
            }
        }

        @Test
        public void test() {
            Solution.movingCount(15, 10, 1);
        }
    }
}