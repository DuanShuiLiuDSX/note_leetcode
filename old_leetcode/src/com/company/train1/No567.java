package com.company.train1;

/**
 * @author cz
 * @Description
 * @date 2021/12/16 15:22
 **/
public class No567 {
    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            int j=0;
            if (s1.charAt(j) == s2.charAt(i)){
                int temp = i+1;
                for (int k=1; k<s1.length(); k++){
                    if (s1.charAt(k) == s2.charAt(temp) && temp<s2.length()){
                        temp++;
                    }else {
                        break;
                    }
                    if (k==s1.length()-1){
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
