import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cz
 * @Description 数据流的中位数
 * @date 2022/4/23 15:34
 **/
public class No41 {
    public class Solution {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        public void Insert(Integer num) {
            numbers.add(num);
            numbers.sort(Comparator.naturalOrder());
        }

        public Double GetMedian() {
            if (numbers.size()%2==0){
                Double res = Double.valueOf(
                        (numbers.get(numbers.size()/2).intValue()+numbers.get(numbers.size()/2-1))/2.0);
                return  res;
            }else
            {
                Double res = Double.valueOf(numbers.get(numbers.size()/2));
                return res;
            }
        }


    }
}
