package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cz
 * @Description 数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * @date 2022/3/16 9:51
 **/
public class BM52 {
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param array int整型一维数组
         * @return int整型一维数组
         */
        public int[] FindNumsAppearOnce (int[] array) {
            // write code here
            int[] res= {-1,-1};
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int i=0; i<array.length; i++){
                if (hashMap.containsKey(array[i])){
                    hashMap.put(array[i], 1);
                }else {
                    hashMap.put(array[i], 0);
                }
            }
            for (int i=0; i<array.length; i++){
                if(hashMap.get(array[i])==0){
                    if (res[0]==-1) {
                        res[0]=array[i];
                    }else {
                        if (res[0]>array[i]){
                            res[1]=res[0];
                            res[0]=array[i];
                        }else {
                            res[1]=array[i];
                        }
                    }
                }
            }
            return res;
        }
    }
}
