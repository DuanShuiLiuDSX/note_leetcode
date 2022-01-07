package com.company.train1;

/**
 * @author cz
 * @Description  双指针指向首尾
 *              然后在首尾找到绝对值最大的数 从数组末尾至首位填进数组里
 * @date 2021/12/12 14:00
 **/
public class No977 {
    public int[] sortedSquares(int[] nums) {
       int len=nums.length, left=0, right=len-1;
       int[] res = new int[len];
        for (int i = len-1; i >=0 ; i--) {
            if(Math.abs(nums[left]) >= Math.abs(nums[right])){
                res[i] = nums[left] * nums[left];
                left++;
            }else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
