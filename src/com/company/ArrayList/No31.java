package com.company.ArrayList;

public class No31 {
    public void  nextPermutation(int[] nums) {
//        int len = nums.length, flag=nums[0];
//        for (int i=0; i<len; i++){
//            if(i>0 && nums[i]>nums[i-1]){
//                flag=nums[i];
//                int pre = nums[i-1];
//            }
//        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        System.out.println(nums);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

//
    }




    public static void main(String[] args) {
        No31 no31 = new No31();
        no31.nextPermutation(new int[]{1,2,4,3,5,4});
    }
}
