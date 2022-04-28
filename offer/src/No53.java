import java.util.Stack;

/**
 * @author cz
 * @Description 数字在升序数组中出现的次数 经典二分
 * @date 2022/4/28 9:59
 **/
public class No53 {
    public int GetNumberOfK(int [] array , int k) {
        int left = 0, right = array.length - 1;
        return search(array, k, right, left);

    }

    private int search(int [] array, int target, int right, int left){
        if(right < left) return 0;
        if(right == left){
            if(array[left] == target){
                return 1;
            }
            return 0;
        }
        int mid = left + (right - left) / 2;
        if(array[mid] == target){
            return 1 + search(array, target, mid - 1, left) + search(array, target, right, mid + 1);
        }
        if(array[mid] < target && array[right] >= target){
            return search(array, target, right, mid + 1);
        }
        if(array[mid] > target && array[left] <= target){
            return search(array, target, left, mid - 1);
        }
        return 0;
    }
}
