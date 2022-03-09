package order.algorithm.greedyAlgorithm;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 跳跃游戏
 * @date 2022/3/2 9:41
 **/
public class No55 {
    static class  Solution {
        /**
         *  从后向前遍历  找到每次可到达的 下标位置 一直往前推
         *  只要i下标的值 nums[i] 大等于 i到reachIndex之间的距离 将i设为新的reachIndex
         * @param nums
         * @return
         */
        public static boolean canJump(int[] nums) {
            int len=nums.length;
            int reachIndex=len-1;
            for (int i=len-2; i>=0; i--){
                if (nums[i] >= (reachIndex-i)){
                    reachIndex = i;
                }
            }
            if (reachIndex==0){
                return true;
            }else {

                return false;
            }
        }


    }
    @Test
    public void test1(){
       No55.Solution.canJump(new int[]{2,3,1,1,4});
    }
}
