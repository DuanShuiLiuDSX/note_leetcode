package com.company.train1;

/**
 * @author cz
 * @Description
 * @date 2021/12/11 15:17
 **/
public class No704 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int index=-1, left=0, right=len-1;
       while (left <= right){
            int temp = nums[(left+right)/2];
            if (temp > target){
                right = (left+right)/2-1;
            }else if (temp < target){
                left = (left+right)/2+1;
            }else {
                index = (left+right)/2;
                break;
            }
        }
        return index;
    }
}
