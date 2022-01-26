package com.company.ArrayList;

import java.util.HashMap;

public class No1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        int size = nums.length;
        hashMap.put(nums[0], 0);
        for (int i = 1;  i< size; i++) {
            if(hashMap.containsKey(target - nums[i]))
                return new int[]{nums[i], i};
            hashMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
