package com.company.ArrayList;

public class No88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] total = new int[m+n];
        int t=0, index1=0, index2=0;
        while (index1 < m && index2 < n){
            if(nums1[index1] <= nums2[index2]){
                total[t] = nums1[index1];
                t++;
                index1++;
            }else {
                total[t] = nums2[index2];
                t++;
                index2++;
            }
        }
        while (index2 < n)
        {
            total[t] = nums2[index2];
            t++;
            index2++;
        }
        while (index1 < m)
        {
            total[t] = nums1[index1];
            t++;
            index1++;
        }
        nums1 = total;
        for (int k:nums1
             ) {
            System.out.print(k);

        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int  m=3 , n=3;
        merge(nums1 ,  m, nums2, n);
    }
}
