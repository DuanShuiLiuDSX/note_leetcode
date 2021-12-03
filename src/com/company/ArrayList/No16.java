package com.company.ArrayList;

import com.company.Main;

public class No16 {
    public int threeSumClosest(int[] nums, int target) {
        int res =nums[0]+nums[1]+nums[2];
        for(int first=0; first<nums.length; first++){
            int third=nums.length-1;
            for (int second=first+1; second<nums.length-1; second++){
                while (second< third){
                    if (Math.abs(nums[first]+nums[second]+nums[third]-target) < Math.abs(res-target)){
                        res = nums[first]+nums[second]+nums[third];
                    }
                    third--;
                }
                third = nums.length-1;
                if (Math.abs(nums[first]+nums[second]+nums[third]-target) < Math.abs(res-target)){
                    res = nums[first]+nums[second]+nums[third];
                }
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        No16 no16 = new No16();
        System.out.println(no16.threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }
}
