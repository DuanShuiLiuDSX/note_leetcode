package com.company.ArrayList;


import org.junit.jupiter.api.Test;

public class No53 {
    public static int maxSubArray(int[] nums) {
        int  max=nums[0], temp=0;
        for ( int item : nums ) {
            temp = Math.max(item , temp+item );
            max  = Math.max(temp, max);
        }
        return  max;
    }

    @Test
    public void test(){
        No53.maxSubArray(new int[]{2,-1,3});
    }

}

