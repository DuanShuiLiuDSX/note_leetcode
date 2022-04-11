import org.junit.jupiter.api.Test;

/**
 * @author cz !!!!!!!!!
 * 1、基本类型（包括String类）作为参数传递时，是传递值的拷贝，无论你怎么改变这个拷贝，原值是不会改变的
 *
 * 2、引用类型（包括数组，对象以及接口）作为参数传递时，是把对象在内存中的地址拷贝了一份传给了参数。
 *
 * 3、注意：基本数据类型的封装类Integer、Short、Float、Double、Long、Boolean、Byte、Character虽然是引用类型，
 * 但它们在作为参数传递时，也和基本数据类型一样，是值传递。

 * @Description 岛屿数量
 * @date 2022/4/11 19:47
 **/
public class lc_200 {

    class Solution1 {

        private int res;
        public int numIslands(char[][] grid) {
            res = 0;
            for (int i = 0; i < grid.length; i ++) {
                for (int j = 0; j < grid[0].length; j ++) {
                    if (grid[i][j] == '1') {
                        dfsGrid(grid, i, j);
                        res ++;
                    }
                }
            }
            return res;
        }

        private void dfsGrid(char[][] grid, int row, int col) {
            if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
                return;
            }
            if (grid[row][col] != '1') {
                return;
            }
            grid[row][col] = '2';
            dfsGrid(grid, row - 1, col);
            dfsGrid(grid, row + 1, col);
            dfsGrid(grid, row, col - 1);
            dfsGrid(grid, row, col + 1);
        }
    }

     static class Solution {
        public static int numIslands(char[][] grid) {
            int res=0;
            int m = grid.length, n=grid[0].length;
            boolean[][] flags = new boolean[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j]=='1'){
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;

        }

        public static void dfs(char[][] grid, int row, int cloumn){
            if(row>=grid.length || row<0 || cloumn>= grid[0].length || cloumn<0)
                return;
            if (grid[row][cloumn]!='1') return;

            if(grid[row][cloumn]=='1')
                grid[row][cloumn]='2';
            dfs(grid, row -1, cloumn);
            dfs(grid, row +1, cloumn);
            dfs(grid, row, cloumn-1);
            dfs(grid, row, cloumn+1);
        }
    }

    @Test
    public void test(){

        int a = Solution.numIslands(new char[][]{
        {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}});
        System.out.println(a);
    }
}
