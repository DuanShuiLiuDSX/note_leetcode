package com.company.train1;

/**
 * @author cz
 * @Description  统计每个数字前 0 的个数， 将其往前移动 count的位置
 *              最后count个数字全部补 0
 * @date 2021/12/13 9:20
 **/
public class No283 {
    public void moveZeroes(int[] nums) {
        int count=0, len=nums.length;
        for (int i=0; i<len; i++){
            if(nums[i]==0){
                count++;
            }else {
                nums[i-count] = nums[i];
            }
        }
        for (int j=len-count; j<len; j++){
            nums[j]=0;
        }
    }
}
