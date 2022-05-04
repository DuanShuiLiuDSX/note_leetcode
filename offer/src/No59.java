import java.util.ArrayList;

/**
 * @author cz
 * @Description 滑动窗口
 * @date 2022/5/4 14:15
 **/
public class No59 {
    public class Solution {
        int position=0;
        public ArrayList<Integer> maxInWindows(int [] num, int size) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            int curMax = max(num, 0, size);
            res.add(curMax);
            for(int i=size; i<num.length; i++){
                if(num[i] >= curMax){
                    res.add(num[i]);
                    curMax = num[i];
                    position = i;
                }else{
                    if(i-position<size){
                        res.add(curMax);
                    }else{
                        curMax = max( num, i-size+1, size );
                        res.add(curMax);
                    }
                }
            }
            return res;
        }

        public int max(int[] num, int begin, int size){
            int max=Integer.MIN_VALUE;
            for(int i=begin; i<begin+size; i++){
                if(num[i]>max){
                    max = num[i];
                    position = i;
                }
            }
            return max;
        }

    }
}
