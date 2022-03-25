package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cz
 * @Description 缺失的第一个正整数
 * 给定一个无重复元素的整数数组nums，请你找出其中没有出现的最小的正整数
 * eg  [-2,3,4,1,5]  return 2
 * @date 2022/3/16 10:21
 **/
public class BM53 {
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param nums int整型一维数组
         * @return int整型
         */
        public int minNumberDisappeared (int[] nums) {
            // write code here

            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int i=0; i<nums.length; i++){
                if (nums[i]>0) {
                    hashMap.put(nums[i], null);}
            }
            int res = 1;
            while (hashMap.containsKey(res)){
                res++;
            }

            return res ==1? res : res++;
        }
    }
}
