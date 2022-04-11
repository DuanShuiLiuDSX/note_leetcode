package binarySearch;

/**
 * @author cz
 * @Description 旋转数组的最小数字
 * @date 2022/4/1 9:57
 **/
public class BM21 {
    public class Solution {
        public int minNumberInRotateArray(int [] array) {

            int left = 0;
            int right = array.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (array[mid] < array[right]) {
                    right = mid;
                } else if (array[mid] > array[right]) {
                    left = mid + 1;
                } else {
                    // mid 与right相等的情况 right左移一个
                    right --;
                }
            }

            return array[left];
        }
    }
}
