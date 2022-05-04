import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cz
 * @Description 最小的K个数
 * @date 2022/4/23 19:57
 **/
public class No40 {
    public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            Arrays.sort(input);
            ArrayList<Integer> res = new ArrayList<Integer>();
            for(int i=0; i<k; i++){
                res.add(input[i]);
            }
            return res;
        }
    }
}
