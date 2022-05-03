import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author cz
 * @Description 和为s的两个数
 * @date 2022/5/3 10:13
 **/
public class No57 {
    // 双指针
    public class Solution1 {
        public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
            ArrayList<Integer> res  = new ArrayList<Integer>();
            int left=0, right = array.length-1;
            while(left<right){
                if(array[left]+array[right]>sum){
                    right--;
                }else if(array[left]+array[right]<sum){
                    left++;
                }else{
                    res.add(array[left]);
                    res.add(array[right]);
                    return res;
                }
            }
            return res;
        }
    }

    // HashMap
    public class Solution {
        public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
            ArrayList<Integer> res  = new ArrayList<Integer>();
            HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();
            for (int i=0; i<array.length; i++){
                map.put(i, array[i]);
            }
            for (int i=0; i<array.length; i++){
                if (map.containsValue(sum-array[i])){
                    if(array[i] == sum-array[i]){
                        if( i+1<array.length && array[i+1]==(sum-array[i]) ){
                            res.add(array[i]);
                            res.add(sum-array[i]);
                            return res;
                        }
                    }else{
                        res.add(array[i]);
                        res.add(sum-array[i]);
                        return res;
                    }
                }
            }
            return res;
        }
    }
}
