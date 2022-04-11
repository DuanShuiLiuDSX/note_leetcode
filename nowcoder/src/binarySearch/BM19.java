package binarySearch;

/**
 * @author cz
 * @Description 寻找峰值
 * @date 2022/3/31 11:02
 **/
public class BM19 {
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 题目规定 相邻元素不相等
         * 在 上升段 一定有峰值
         *
         * @param nums int整型一维数组
         * @return int整型
         */
        public int findPeakElement (int[] nums) {
            // write code here
            int len=nums.length;
            int left=0, right=len-1;
            // left < right,  mid+1就不会越界
            while(left<right){
                int mid=(left+right)/2;
                // 条件为相邻元素的判断
                if(nums[mid]>nums[mid+1])
                    right=mid;
                else
                    left=mid+1;
            }
            return left;
        }
    }
}
