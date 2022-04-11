package binarySearch;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 二维数组的查找
 * @date 2022/3/31 9:50
 **/
public class BM18 {
    public static class Solution {
        public static boolean Find(int target, int [][] array) {
            int len1=array.length, len2=array[0].length;
            /**
             *  O(nlog(n))的时间复杂度
             */
            for (int i=0; i<len1; i++){
                int left=0, right=len2-1;
                while (left<=right){
                    int mid = (left+right)/2;
                    if (array[i][mid]==target)return true;
                    else if(array[i][mid]>target) right=mid-1;
                    else left=mid+1;
                }
            }
            return false;
        }
    }

    @Test
    public void test(){
        Solution.Find(1, new int[][]{{1,2}});
    }
}
