package order.binarySearch;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cz
 * @Description
 * @date 2022/3/3 13:47
 **/
public class No34 {
    static class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[] {-1, -1};
            res[0] = binarySearch(nums, target, true);
            res[1] = binarySearch(nums, target, false);
            return res;
        }
        //leftOrRight为true找左边界 false找右边界
        public int binarySearch(int[] nums, int target, boolean leftOrRight) {
            int res = -1;
            int left = 0, right = nums.length - 1, mid;
            while(left <= right) {
                mid = left + (right - left) / 2;
                if(target < nums[mid])
                    right = mid - 1;
                else if(target > nums[mid])
                    left = mid + 1;
                else {
                    res = mid;
                    //处理target == nums[mid]
                    if(leftOrRight)
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }
            return res;
        }
    }

    // O(n) 复杂度
    static class Solution {
        public static int[] searchRange(int[] nums, int target) {
            int pre=0, after=0;
            boolean flag=false;
            for(int i=0; i<nums.length-1; i++){
                if(nums[i]==target){
                    pre=i;
                    flag=true;
                    break;
                }
            }
            if(!flag){
                return new int[]{-1,-1};
            }
            flag=false;
            for(int i=nums.length-1; i>=0;  i--){
                if(nums[i]==target){
                    after=i;
                    flag=true;
                    break;
                }
            }
            if(!flag){
                return new int[]{pre, pre};
            }
            return new int[]{pre, after};

        }
    }

    @Test
    public void test1() {
        int[] res = No34.Solution.searchRange(new int[]{1}, 1);
    }
}

//二分查找通用模板
class BinarySearchSolution {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = getFirstIndex(nums, target);
        int lastIndex = getLastIndex(nums, target);
        return new int[]{firstIndex, lastIndex};
    }

    public int getFirstIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    public int getLastIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[right] == target) {
            return right;
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}

