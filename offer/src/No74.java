import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author cz
 * @Description 和为s的连续序列
 * @date 2022/5/6 9:59
 **/
public class No74 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        int begin = sum/2+1;
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        ArrayList<Integer> subRes = new ArrayList<>();
        int temp = 0;
        for(int i=begin; i>0; i--){
            temp += i;
            subRes.add(i);
            if(temp < sum){
            }else if(temp>sum){
                temp-=subRes.get(0);
                subRes.remove(0);
            }else{
                i=subRes.get(0);
                subRes.sort(Comparator.naturalOrder());
                if (subRes.size()>1){
                    res.add(0,new ArrayList(subRes));
                }
                subRes.clear();
                temp = 0;
            }
        }
        return res;
    }

    @Test
    public void test(){
        No74 no74 = new No74();
        no74.FindContinuousSequence(15);
    }
}
