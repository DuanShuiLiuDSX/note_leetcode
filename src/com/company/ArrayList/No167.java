package com.company.ArrayList;

public class No167 {
    public int[] twoSum(int[] numbers, int target) {
        int left=0, right=numbers.length-1;
        while(left<right){
            if(numbers[left]+numbers[right]< target){
                left++;
            }else if(numbers[left]+numbers[right] > target){
                right--;
            }else{
                int[] a = new int[]{left+1, right+1};
                return a;
            }
        }
        return new int[]{0,0};
    }
}
