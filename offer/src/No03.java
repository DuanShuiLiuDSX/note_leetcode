import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cz
 * @Description 数组中重复数字
 * @date 2022/4/8 9:10
 **/
public class No03 {
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param numbers int整型一维数组
         * @return int整型
         */
        public int duplicate (int[] numbers) {
            // write code here
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<numbers.length; i++){
                if(map.containsKey(numbers[i]))
                    return numbers[i];
                map.put(numbers[i], numbers[i]);
            }
            return -1;
        }

        public int duplicate1 (int[] numbers) {
            Arrays.sort(numbers);
            for(int i=0; i<numbers.length-1; i++){
                int temp=numbers[i+1];
                if(numbers[i]==temp) return temp;
            }
            return -1;

        }
        public int duplicate2 (int[] numbers) {
            for (int i=0; i<numbers.length; i++){
                int temp = numbers[i];
                while (numbers[i] != numbers[temp]){
                    numbers[i]=numbers[temp];
                    numbers[temp] = temp;
                    temp = numbers[i];
                }
                if (numbers[i]==numbers[temp])return numbers[i];
            }
            return -1;
        }

    }
}
