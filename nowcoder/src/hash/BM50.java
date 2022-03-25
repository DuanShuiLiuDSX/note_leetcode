package hash;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author cz
 * @Description 两数之和
 * @date 2022/3/16 9:06
 **/
public class BM50 {
    public class Solution {
        /**
         *
         * @param numbers int整型一维数组
         * @param target int整型
         * @return int整型一维数组
         */
        public int[] twoSum (int[] numbers, int target) {
            // write code here
            int[] res = new int[2];
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < numbers.length; i++) {
                hashMap.put(numbers[i], i);
            }
            for (int i=0; i<numbers.length; i++){
                if(hashMap.get(target-numbers[i]) !=null){
                    if (hashMap.get(target-numbers[i]) < i){
                        res[0]=hashMap.get(target-numbers[i]);
                        res[1]=i;
                        break;
                    }else if (hashMap.get(target-numbers[i]) > i){
                        res[1]=hashMap.get(target-numbers[i]);
                        res[0]=i;
                        break;
                    }
                }
            }
            return res;
        }
    }

}
