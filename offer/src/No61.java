import org.junit.jupiter.api.Test;


import java.util.Arrays;

/**
 * @author cz
 * @Description 扑克牌顺子
 * @date 2022/5/4 13:02
 **/
public class No61 {

    public class Solution {
        public boolean IsContinuous(int [] numbers) {
            Arrays.sort(numbers);
            int count=0;
            int gap = 0;
            for(int i=0; i<5; i++){
                if(numbers[i]==0) {
                    count++;
                    continue;
                }
                if(i>0 && numbers[i-1]!=0){
                    if(numbers[i]==numbers[i-1]) return false;
                    gap += numbers[i]-numbers[i-1]-1;
                }
            }
            if(gap==0) return true;
            return gap==count ? true : false;
        }
    }
    @Test
    public void test(){
        int[] ints = new int[]{1,2,5,4};
        Arrays.sort(ints);
        System.out.println(ints);
    }
}
