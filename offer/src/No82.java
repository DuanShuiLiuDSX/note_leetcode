import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 调整数组奇偶数顺序
 * @date 2022/5/8 15:24
 **/
public class No82 {

        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param array int整型一维数组
         * @return int整型一维数组
         */
        public int[] reOrderArrayTwo (int[] array) {
            // write code here
            int left=0, right=array.length-1;
            while(left<right){
                if(array[left]%2==1) left++;
                if(array[right]%2==0) right--;
                if(array[left]%2==0 && array[right]%2==1){
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                    left++;
                    right--;
                }
            }
            return array;
        }


    @Test
    public void test(){
        No82 no82=  new No82();
        no82.reOrderArrayTwo(new int[]{1,4,4,3});
    }
}
