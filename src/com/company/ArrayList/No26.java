package com.company.ArrayList;

public class No26 {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int idx =0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(nums[idx] != nums[j]){
                    nums[++idx] = nums[j];
                    i = j;
                }
            }
        }
        idx += 1;
        return idx;
    }

    public static void main(String[] args) {
        int a = removeDuplicates(new int[]{1,2,3,3});
    }
}

