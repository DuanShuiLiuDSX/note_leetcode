package com.company.train1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cz
 * @Description  思路  从 为0的点开始 寻找与不为0的点的位置的距离
 * @date 2021/12/23 19:57
 **/
public class No542 {
        public int[][] updateMatrix(int[][] matrix) {
            Queue<int[]> queue = new LinkedList<>();
            int m = matrix.length, n=matrix[0].length;
            for(int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    if (matrix[i][j] == 0){
                        queue.offer(new int[]{i, j});
                    }else {
                        matrix[i][j] = -1;
                    }
                }
            }

            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};
            while (!queue.isEmpty()){
                int[] position = queue.poll();
                int x = position[0], y = position[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x+dx[i];
                    int newY = y+dy[i];
                    if (newX >=0 && newY>=0 && newX<m && newY<n && matrix[newX][newY]==-1){
                        matrix[newX][newY]=matrix[x][y]+1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        return matrix;
        }


    public static void main(String[] args) {
        No542 no542 = new No542();
        int[][] array = new int[][] {{0,0,0}, {0,1,0},{0,1,1}};
        array = no542.updateMatrix(array);
        System.out.println(array);
    }
}
