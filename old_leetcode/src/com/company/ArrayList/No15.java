package com.company.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int left=0; left<len; ++left)
        {
            if (nums[left]>0){
                return lists;
            }

            if (left >0 && nums[left]==nums[left-1]){
                continue;
            }

            int right=left+1, third = len-1;
            int temp = nums[left];
            while (right< third ){
                int res = temp+nums[right]+nums[third];
                if(res==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(temp);
                    list.add(nums[right]);
                    list.add(nums[third]);
                    lists.add(list);
                    while (right<third && nums[right]==nums[right+1]) right++;
                    while (right<third && nums[third]==nums[third-1]) third--;
                    right++;
                    third--;
                }else if (res>0){
                    third--;
                }else {
                    right++;
                }
                }
        }
        return lists;
    }

    public static void main(String[] args) {
        No15 no15 = new No15();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(no15.threeSum(nums));
    }
}
