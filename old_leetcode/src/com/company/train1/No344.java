package com.company.train1;

/**
 * @author cz
 * @Description 反转字符串
 * @date 2021/12/14 15:15
 **/
public class No344 {
    public void reverseString(char[] s) {
        int left=0, right=s.length-1;
        char temp ;
        while (left<right){
            temp = s[left];
            s[left]=s[right];
            s[right]=temp;
            right--;
            left++;
        }
    }
}
