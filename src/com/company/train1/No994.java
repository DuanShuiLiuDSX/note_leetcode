package com.company.train1;

import javax.sound.midi.Synthesizer;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cz
 * @Description  思路同 no542  将值为2的坐标入队  广度搜索值为 1 的位置
 *                 将新的值入队 并且监督队列长度的变化 来判断进行到第几轮
 *
 * @date 2022/1/5 13:35
 **/
public class No994 {
    public int orangesRotting(int[][] grid) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int res = -1;
        int size = queue.size();

        // 判断[[0,1]] 输出是-1  [[0, 0]]输出是0 类似的情况（有一个 1 就可以归为0）
        if (size == 0 ){
            int flag = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j]==1){
                        flag=1;
                    }
                }
            }
            if (flag==0){
                return 0;
            }else {
                return -1;
            }
        }

        while (!queue.isEmpty()){
            int[] position = queue.poll();
            size--;
            int x = position[0], y = position[1];
            for (int i=0; i<4; i++){
                int newX = x + dx[i], newY = y + dy[i];
                if (newX>-1 && newX<m && newY>-1 && newY<n && grid[newX][newY]==1){
                    grid[newX][newY]=2;
                    queue.offer(new int[]{newX, newY});
                }
            }
            if (size==0){
                res++;
                size = queue.size();
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No994 no994 = new No994();
        int[][] a = new int[][]{{0}};
        System.out.println(a[0][0]);
        no994.orangesRotting(new int[][]{{0}});
        System.out.println( no994.orangesRotting(a));
    }
}
