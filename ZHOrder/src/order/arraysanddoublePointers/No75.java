package order.arraysanddoublePointers;

/**
 * @author cz
 * @Description 颜色分类
 * @date 2022/1/6 14:08
 **/
public class No75 {
    /*
       单指针解法
     */
    public void sortColors(int[] nums) {
        int p0 = 0, len = nums.length;
        while (p0 < len && nums[p0] == 0) {
            p0++;
        }
        for (int i = p0 + 1; i < len; i++) {
            if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                p0++;
            }
        }
        while (p0 < len && nums[p0] == 1) {
            p0++;
        }
        for (int i = p0 + 1; i < len; i++) {
            if (nums[i] == 1) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                p0++;
            }
        }

    }

    /**
     * 双指针解法
     * @param nums
     */


    public void sortColors_method2(int[] nums) {
       int p0=0, p2=nums.length-1;
       for (int i=0; i<=p2; i++){
           /**
            * 将 尾部遍历到非2的位置
            *  若 nums[i]==2 与 nums[p2]==2 交换后，i+1 那么相当于没改变
            *  所以将p2-- 找到不是2的位置
            */
           while (i<=p2 && nums[i]==2){
               int temp = nums[i];
               nums[i] = nums[p2];
               nums[p2] = temp;
               p2--;
           }

           if (nums[i]==0){
               int temp = nums[i];
               nums[i] = nums[p0];
               nums[p0] = temp;
               p0++;
           }
       }
    }
}
