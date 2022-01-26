package com.company.ArrayList;

public class No66 {
    public int[] plusOne(int[] digits) {
        int  n = digits.length-1, j=n;
        for (int i = n; i >0 ; i--) {
            digits[i]+=1;
            if(digits[i]!=10){
                return digits;
            }else {
                digits[i]=0;
                j=i;
            }
        }

        if(j==0){
            int[] newDigit = new int[n+2];
            newDigit[0]=1;
            return newDigit;
        }else{
            return digits;
        }
    }
}
