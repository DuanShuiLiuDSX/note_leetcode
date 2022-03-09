package dp;
import java.util.Scanner;

/**
 * @author cz
 * @Description 连续子数组最大和
 *
 * @date 2022/3/9 10:56
 **/
public class DP6 {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = s.nextInt();
        }
        int temp=0, max=nums[0];
        for(int i=0; i<n; i++){
            // temp 代表 i 前序列的和 （前提 前i-1个序列和大于 当前 数字， 若不大于 temp置为当前数字）
            temp = Math.max(nums[i], temp+nums[i]);
            // max 来判断每次的最大值
            max = Math.max(max, temp);
        }
        System.out.print(max);
    }
}
