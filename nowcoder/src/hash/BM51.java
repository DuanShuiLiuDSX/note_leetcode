package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cz
 * @Description 数组中出现次数超一半的数字
 * @date 2022/3/16 9:38
 **/
public class BM51 {
    public class Solution {
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array.length == 0){
                return 0;
            }

            int len = array.length;
            int threshold = len/2;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < len; i++){
                if(!map.keySet().contains(array[i])){
                    map.put(array[i],1);
                }else{
                    map.put(array[i],map.get(array[i])+1);
                }
            }

            for(Integer key: map.keySet()){
                if(map.get(key) > threshold){
                    return key;
                }
            }

            return 0;
        }
    }

    /**
     *  优解
     *  超一半个数，说明数量一定大于其他数字的数量
     */
    public class Solution1{
        public int MoreThanHalfNum_Solution(int [] array) {
            if (array.length==0)return 0;
            int target=array[0], count=1;
            if (array.length==1) return target;
            // 找出出现次数最多的数字
            for (int i=1; i<array.length; i++){
                if (array[i]==target){
                    count++;
                }else{
                    count--;
                    if (count==0){
                        target=array[i];
                        count=1;
                    }
                }
            }
            // 出现次数最多 不一定就是超过 数组长度一半的数
            count=0;
            for (int i=0; i<array.length; i++){
                if (array[i]==target)count++;
            }
            return count> array.length/2 ? target:0;

        }
    }
}
