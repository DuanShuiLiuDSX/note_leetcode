package order.binarySearch;

import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description
 * @date 2022/3/3 20:13
 **/
public class No33 {
    static class Solution {
        public static int search(int[] nums, int target) {
            int res = -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < nums[right]) {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (target < nums[mid] && target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return res;
        }

        @Test
        public void test() {
            Solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        }
    }
}