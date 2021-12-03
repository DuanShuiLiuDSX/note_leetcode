package com.company.ArrayList;

public class No11 {
    public int maxArea(int[] height) {
        int max=0;
        int left=0, right=height.length-1;
        while (left<right){
            max = Math.max(max, (right-left)*Math.min(height[left], height[right]));
            if(height[left]<= height[right]){
                left++;
            }else if (height[left] > height[right]){
                right--;
            }
        }
        return max;
    }
}
