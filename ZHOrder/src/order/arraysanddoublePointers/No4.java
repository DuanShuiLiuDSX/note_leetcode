package order.arraysanddoublePointers;

/**
 * @author cz
 * @Description 时间复杂度 log(m+n) 查找中位数
 * @date 2022/1/8 15:47
 **/
public class No4 {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length, len2 = nums2.length;
            if ((len1 + len2) % 2 == 1) {
                int k = (len1 + len2) / 2;
                return getKElement(nums1, nums2, k + 1);
            } else {
                int k1 = (len1 + len2) / 2 - 1, k2 = k1 + 1;
                double res = (getKElement(nums1, nums2, k1 + 1) + getKElement(nums1, nums2, k2 + 1)) / 2.0;
                return res;
            }
        }

        public int getKElement(int[] nums1, int[] nums2, int k) {
            int len1 = nums1.length, len2 = nums2.length;
            int index1 = 0, index2 = 0;
            while (true) {
                if (index1 == len1) {
                    return nums2[index2 + k - 1];
                }
                if (index2 == len2) {
                    return nums1[index1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }
                //
                int mid = k / 2;
                int newIndex1 = Math.min(mid + index1, len1) - 1, newIndex2 = Math.min(mid + index2, len2) - 1;
                int value1 = nums1[newIndex1], value2 = nums2[newIndex2];
                if (value1 <= value2) {
                    k = k - newIndex1 + index1 - 1;
                    index1 = newIndex1 + 1;
                } else {
                    k = k - newIndex2 + index2 - 1;
                    index2 = newIndex2 + 1;
                }
            }
        }

        public static void main(String[] args) {
            Solution s1 = new Solution();
            s1.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        }
    }
}
