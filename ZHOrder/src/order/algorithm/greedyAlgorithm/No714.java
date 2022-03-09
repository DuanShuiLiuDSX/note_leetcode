package order.algorithm.greedyAlgorithm;
import org.junit.jupiter.api.Test;


/**
 * @author cz
 * @Description 买卖股票最佳时机
 * @date 2022/3/1 13:31
 **/
public class No714 {
    public int maxProfit(int[] prices, int fee) {
        int curProfit=0;
        int buy =prices[0]+fee;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]+fee < buy){
                buy = prices[i]+fee;
            }else if(prices[i]>buy){
                curProfit +=prices[i]-buy;
                buy = prices[i];
            }
        }
        return curProfit;
    }

    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{1,3,2,8,7,9}, 2));
    }
}
