package com.company.train1;

/**
 * @author cz
 * @Description
 * @date 2021/12/11 15:29
 **/
public class No278 {
    public int firstBadVersion(int n) {
        int left = 1, right = n, index=1;
        while (left <= right) {
            int mid = (left+right)/2;
            if(isBadVersion(mid)){
                right = mid-1;
                index = mid;
            }else {
                left = mid+1;
            }
        }
        return index;
    }

    public boolean isBadVersion(int bad){
        if(bad==4){
            return true;
        }else
            return false;
    }
}
