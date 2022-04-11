/**
 * @author cz
 * @Description 旋转数组的最小数字
 * @date 2022/4/11 9:37
 **/
public class No11 {
    public class Solution {
        public int minNumberInRotateArray(int [] array) {
            int left=0, right=array.length-1;
            while (left<right){
                int mid = (left+right)/2;
                if (array[right] < array[mid]) {
                    left=mid+1;
                }else if (array[mid] < array[right]){
                    right=mid;
                // 考虑 [1,1,1,0,1] 情况， 当left==right right左移一位
                }else {
                    right--;
                }
            }
            return array[left];
        }
    }
}
