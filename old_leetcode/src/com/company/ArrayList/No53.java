package com.company.ArrayList;

public class No53 {
    public int maxSubArray(int[] nums) {
        int index=0, max=nums[0], temp=max;
        for ( int item : nums ) {
             temp = Math.max(item , temp+item );
             max  = Math.max(temp, max);
        }
        return  max;
    }
}
