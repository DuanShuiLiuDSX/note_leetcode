package com.company.train1;

/**
 * @author cz
 * @Description
 *   三次反转数组 来解题
 * @date 2021/12/12 15:43
 **/
public class No189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }

    public int[] reverse(int[] nums, int l, int r){
        while (l<r){
            int t= nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
        return nums;
    }
}
