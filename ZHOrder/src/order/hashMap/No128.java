package order.hashMap;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cz
 * @Description 最长连续序列
 * @date 2022/2/23 9:58
 **/
public class No128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set= new HashSet<Integer>();
        for (int num : nums){
            set.add(num);
        }
        //maxLength=0 解决nums为空的情况
        int maxLength=0;
        for (int num: set){
            // 找到每个子段的最小元素  [1,2,3,   5,6,   11,12,13,14,15]  三个子段
            if (!set.contains(num-1)){
                int curLength=1;
                int curNumber = num;
                while (set.contains(curNumber+1)){
                    curLength++;
                    curNumber++;
                }
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }

    @Test
    public void  test(){
        No128 no128 = new No128();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(no128.longestConsecutive(nums));
    }
}
