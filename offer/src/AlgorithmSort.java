import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author cz
 * @Description 经典排序算法
 * @date 2022/4/28 10:45
 **/
public class AlgorithmSort {

    /**
     *  冒泡排序
     */
    public void popSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            Boolean flag = true;
            for (int j = 0; j < array.length-i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            // 假如 flag 不变 表示数组已经有序
            if (flag) return;
        }
    }

    /**
     *  选择排序
     */
    public void selectionSort(int[] array){
        for (int i=0; i<array.length; i++){
            int temp = array[i];
            int tempIndex = i;
            for (int j=i+1; j<array.length; j++){
                if (array[j]< temp){
                    temp = array[j];
                    tempIndex = j;
                }
            }
            array[tempIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     * 插入排序
     * @param array
     */
    public void insertSort(int[] array){
        for (int i=1; i<array.length; i++){
            int temp = array[i];
            int j=i-1;
            // 寻找需要插入的位置 并且将相应的元素向后移动
            for ( ;j>=0 && temp>array[j]; j--){
                array[j] = array[j-1];
            }
            array[j+1] = temp;
        }
    }

    /**
     * 希尔排序
     * 内部 还是插入排序
     */
    public void hillSort(int[] array){
        int len = array.length;
        for (int step=len/2; step>=1; step/=2){
            int temp;
            for (int i=step; i<len; i++){
                temp = array[i];
                int j=i-step;
                while(j>=0 && temp<array[j]){
                    array[j]=array[j-temp];
                    j-=temp;
                }
                array[j+step] = temp;
            }
        }
    }

    /**
     * 归并排序
     */
    public int[] mergeSort(int[] array){
        if (array.length <2)
            return array;
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] leftArray, int[] rightArray){
        int resLength = leftArray.length + rightArray.length;
        int[] res = new int[resLength];
        int i=0, j=0, resIndex=0;
        while (i<leftArray.length && j<rightArray.length){
            res[resIndex++] = Math.max(leftArray[i], rightArray[j]);
            if (leftArray[i] >= rightArray[j]) i++;
            else j++;
        }
        while(i!=leftArray.length){
            res[resIndex++] = leftArray[i++];
        }
        while (j!=rightArray.length){
            res[resIndex++] = rightArray[j++];
        }
        return res;
    }

    /**
     *  快速排序  pivot 选择左边左边第一个 就从 right开始查找
     */
    public int[] quickSort(int left, int right, int[] array){
        // 防止死循环
        int cirLeft = left, cirRight = right;
        if (left>=right) return array;
        int pivot = array[left];
        while (left<right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            if (left < right) {
                int temp = array[right];
                array[right] = pivot;
                array[left] = temp;
            }

            while (left < right && array[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = pivot;
                array[right] = temp;
            }
        }
        quickSort(cirLeft, left, array);
        quickSort(left + 1, cirRight, array);
        return array;
    }

    @Test
    public void test(){
        int[] res = quickSort(0, 9, new int[]{5,122,45,42,3,6,7,9,1,2});
        for (int i : res){
            System.out.println(i);
        }
    }
}
