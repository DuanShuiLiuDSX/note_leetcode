package order.algorithm.greedyAlgorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cz
 * @Description 根据身高建模
 * 将元素按升高降序， 同身高 按照 位置升序排列
 * input [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 排序后  [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
 * 依次插入新的队列中 此时位置 ki就是插入的位置
 *  原理 先插入个子高的 个子矮的位置  对其就没有影响
 * @date 2022/3/3 10:20
 **/
public class No406{
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            //o1[1] - o2[1] 第二个位置升序     o2[0] - o1[0] 第一个位置降序
            Arrays.sort(people,
                    (o1, o2) ->
                    o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

            LinkedList<int[]> list = new LinkedList<>();
            for (int[] i : people) {
                list.add(i[1], i);
            }

            return list.toArray(new int[list.size()][2]);
        }


    }

    @Test
    public void test1(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(0, 0);  // 自动将元素往后移动
        System.out.println(list); //[0, 1]
        int[] ints;
//        ints = list.toArray(new Integer[][]{new Integer[1]});
    }
}
