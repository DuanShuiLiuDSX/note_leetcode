package order.hashMap;

/**
 * @author cz
 * @Description 和为K的子数组
 * @date 2022/2/24 13:46
 **/
public class No560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count=0;
            for (int i = 0; i < nums.length; i++) {
                int temp=k;
                for (int j = i; j <nums.length ; j++) {
                    if ((temp-nums[j])>0){
                        temp-=nums[j];
                    }else if((temp-nums[j])==0){
                        temp-=nums[j];
                        count++;
                    }else {
                        break;
                    }
                }
            }
            return count;
        }
    }
}
