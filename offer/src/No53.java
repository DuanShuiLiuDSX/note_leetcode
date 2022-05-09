import java.util.Stack;

/**
 * @author cz
 * @Description 数字在升序数组中出现的次数 经典二分
 * @date 2022/4/28 9:59
 **/
public class No53 {
    public int GetNumberOfK(int [] array , int k) {
        return binarySearch(array, 0, array.length-1, k);
    }

    public int binarySearch(int[] array, int left, int right, int target){
        if(left > right){
            return 0;
        }
        int mid = (left+right)/2;
        if(array[mid]==target){
            return 1+binarySearch(array, left, mid-1, target)+
                    binarySearch(array, mid+1, right, target);
        }else if(array[mid]> target)
            return binarySearch(array, left, mid-1, target);
        else
            return binarySearch(array, mid+1, right, target);
    }
}
