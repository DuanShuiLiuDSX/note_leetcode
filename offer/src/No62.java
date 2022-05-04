import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author cz
 * @Description
 * @date 2022/5/4 13:37
 **/
public class No62 {
    public class Solution {
        public int LastRemaining_Solution(int n, int m) {
            Queue<Integer> queue = new ArrayDeque<Integer>();
            for (int i=0; i< n; i++){
                queue.add(i);
            }
            while (queue.size()>1){
                for (int i = 0; i<m; i++){
                    if (i==m-1){
                        queue.poll();
                    }else {
                        queue.add(queue.poll());
                    }
                }
            }
            return queue.poll();
        }
    }
}
