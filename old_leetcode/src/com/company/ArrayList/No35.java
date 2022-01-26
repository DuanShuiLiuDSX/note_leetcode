package com.company.ArrayList;

public class No35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length, left=0, right=len-1;
        int index=0;
        while (left <= right){
            index  = (left+right)/2;
            if(target > nums[index]){
                left = index+1;
            }else if(target<nums[index]){
                right = index-1;
            }else{
                return index;
            }
        }
        return target<nums[index] ? index: index+1;
    }
}
