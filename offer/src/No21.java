/**
 * @author cz
 * @Description 调整奇偶数的位置
 * @date 2022/4/18 9:32
 **/
public class No21 {
    class Solution {
        public int[] exchange(int[] nums) {

            int left=0, right=nums.length-1;
            while(left<right){
                if(nums[left]%2==1){
                    left++;
                }else{
                    if(nums[right]%2==1){
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] =temp;
                        left++; right--;
                    }else{
                        right--;
                    }
                }
            }
            return nums;
        }
    }
}
